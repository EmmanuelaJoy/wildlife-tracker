package dao;

import models.Endangered_Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEndangeredAnimalDao implements EndangeredAnimalDao{
    private final Sql2o sql2o;

    public Sql2oEndangeredAnimalDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Endangered_Animal> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM endangered_animals").executeAndFetch(Endangered_Animal.class);
        }
    }

    @Override
    public void add(Endangered_Animal endangered_animal) {
        String sql = "INSERT INTO endangered_animals (type , name , age, health) VALUES (:type , :name , :age, :health)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(endangered_animal).executeUpdate().getKey();
            endangered_animal.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Endangered_Animal findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM endangered_animals WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Endangered_Animal.class);
        }
    }

    @Override
    public void update(int id, String newType, String newName, String newAge, String newHealth) {
        String sql = "UPDATE endangered_animals SET type= :type, name = :name, age = :age, health = :health WHERE id=:id";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).addParameter("id", id).addParameter("type", newType).addParameter("name", newName).addParameter("age", newAge).addParameter("health", newHealth).executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from endangered_animals WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllEndangeredAnimals() {
        String sql = "DELETE from endangered_animals";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
