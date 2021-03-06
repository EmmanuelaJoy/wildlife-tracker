import static spark.Spark.*;

import dao.*;
import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        Sql2oRangerDao rangerDao = new Sql2oRangerDao(sql2o);
        Sql2oAnimalDao animalDao = new Sql2oAnimalDao(sql2o);
        Sql2oEndangeredAnimalDao endangeredAnimalDao = new Sql2oEndangeredAnimalDao(sql2o);
        Sql2oLocationDao locationDao = new Sql2oLocationDao(sql2o);
        Sql2oSightingsDao sightingsDao = new Sql2oSightingsDao(sql2o);

        get("/", (request,response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            locationDao.clearAllLocations();
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfLocationToDelete = Integer.parseInt(req.params("id"));
            locationDao.deleteById(idOfLocationToDelete);
            model.put("location", locationDao.getAll());
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            animalDao.clearAllAnimals();
            endangeredAnimalDao.clearAllEndangeredAnimals();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfCommonAnimalToDelete = Integer.parseInt(req.params("id"));
            animalDao.deleteById(idOfCommonAnimalToDelete);
            model.put("commonAnimals", animalDao.getAll());
            model.put("endangeredAnimals", endangeredAnimalDao.getAll());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/animal/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEndangeredAnimalToDelete = Integer.parseInt(req.params("id"));
            endangeredAnimalDao.deleteById(idOfEndangeredAnimalToDelete);
            model.put("commonAnimals", animalDao.getAll());
            model.put("endangeredAnimals", endangeredAnimalDao.getAll());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            rangerDao.clearAllRangers();
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfRangerToDelete = Integer.parseInt(req.params("id"));
            rangerDao.deleteById(idOfRangerToDelete);
            model.put("ranger", rangerDao.getAll());
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "rangerForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("rangerName");
            int badgeNumber=Integer.parseInt(request.queryParams("rangerBadgeNumber"));
            int phoneNumber=Integer.parseInt(request.queryParams("rangerPhoneNumber"));
            String emailAddress=request.queryParams("rangerEmailAddress");
            Ranger ranger = new Ranger(name, badgeNumber, phoneNumber, emailAddress);
            rangerDao.add(ranger);
            model.put("ranger", ranger);
            return new ModelAndView(model, "rangerForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rangers", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Ranger> ranger = rangerDao.getAll();
            model.put("ranger", ranger);
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual ranger
        get("/rangers/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfRangerToFind = Integer.parseInt(req.params("id"));
            Ranger foundRanger = rangerDao.findById(idOfRangerToFind);
            model.put("ranger", foundRanger);
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a ranger
        get("/rangers/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfRangerToEdit = Integer.parseInt(req.params("id"));
            Ranger rangerToEdit = rangerDao.findById(idOfRangerToEdit);
            model.put("rangerToEdit", rangerToEdit);
            return new ModelAndView(model, "rangerForm.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a ranger
        post("/rangers/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("rangerName");
            int badgeNumber=Integer.parseInt(request.queryParams("rangerBadgeNumber"));
            int phoneNumber=Integer.parseInt(request.queryParams("rangerPhoneNumber"));
            String emailAddress=request.queryParams("rangerEmailAddress");
            int idOfRangerToEdit = Integer.parseInt(request.params("id"));
            Ranger editRanger = rangerDao.findById(idOfRangerToEdit);
            rangerDao.update(idOfRangerToEdit, name, badgeNumber, phoneNumber, emailAddress);
            return new ModelAndView(model, "rangers.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animalForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String type = request.queryParams("type");
            String commonAnimalName = request.queryParams("commonAnimalName");
            String commonAnimalAge = request.queryParams("commonAnimalAge");
            String endangeredAnimalName = request.queryParams("endangeredAnimalName");
            String endangeredAnimalAge = request.queryParams("endangeredAnimalAge");
            String health = request.queryParams("endangeredAnimalHealth");
            if(type.equals("common")) {
                Common_Animal common_animal = new Common_Animal(type, commonAnimalName, commonAnimalAge);
                animalDao.add(common_animal);
                model.put("commonAnimal", common_animal);
            } else{
                Endangered_Animal endangered_animal = new Endangered_Animal(type, endangeredAnimalName, endangeredAnimalAge, health);
                endangeredAnimalDao.add(endangered_animal);
                model.put("endangeredAnimal", endangered_animal);
            }
            return new ModelAndView(model, "animalForm.hbs");
        },new HandlebarsTemplateEngine());

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("commonAnimals", animalDao.getAll());
            model.put("endangeredAnimals", endangeredAnimalDao.getAll());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfCommonAnimalToFind = Integer.parseInt(req.params("id"));
            Common_Animal common_animal = animalDao.findById(idOfCommonAnimalToFind);
            model.put("common_animal", common_animal);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update an animal
        get("/animals/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAnimalToEdit = Integer.parseInt(req.params("id"));
            Common_Animal common_animal = animalDao.findById(idOfAnimalToEdit);
            model.put("editedAnimal", common_animal);
            return new ModelAndView(model, "animalForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/location/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/locations", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("location");
            Location location = new Location(name);
            locationDao.add(location);
            model.put("location", location);
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Location> locations = locationDao.getAll();
            model.put("location", locations);
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfLocationToEdit = Integer.parseInt(req.params("id"));
            Location editLocation = locationDao.findById(idOfLocationToEdit);
            model.put("editedLocation", editLocation);
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a location
        post("/locations/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("location");
            int idOfLocationToEdit = Integer.parseInt(request.params("id"));
            Location editLocation = locationDao.findById(idOfLocationToEdit);
            locationDao.update(idOfLocationToEdit, name);
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("rangers", rangerDao.getAll());
            model.put("commonAnimals", animalDao.getAll());
            model.put("endangeredAnimals", endangeredAnimalDao.getAll());
            model.put("locations", locationDao.getAll());
            return new ModelAndView(model, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int rangerId = Integer.parseInt(request.queryParams("ranger"));
            int animalId = Integer.parseInt(request.queryParams("animal"));
            int locationId = Integer.parseInt(request.queryParams("location"));
            Sighting sighting = new Sighting(rangerId, animalId, locationId);
            sightingsDao.add(sighting);
            model.put("sightings", sighting);
            return new ModelAndView(model, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sighting> sightings = sightingsDao.getAll();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
