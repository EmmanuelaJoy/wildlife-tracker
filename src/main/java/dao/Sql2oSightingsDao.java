package dao;

import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSightingsDao implements SightingsDao{

    private final Sql2o sql2o;

    public Sql2oSightingsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Sighting> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM sightings").executeAndFetch(Sighting.class);
        }
    }

    @Override
    public void add(Sighting sighting) {
        String sql = "INSERT INTO sightings (rangerID, animalID, locationID, timestamp ) VALUES (:rangerID, :animalID, :locationID, timestamp )";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(sighting).executeUpdate().getKey();
            sighting.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Sighting findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM sightings WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Sighting.class);
        }
    }

    @Override
    public void update(int id, int newRangerID, int newAnimalID, int newLocationID) {
        String sql = "UPDATE sightings SET rangerID = :rangerID, animalID = :animalID, locationID = :locationID, timestamp = timestamp WHERE id=:id";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).addParameter("rangerID", newRangerID).addParameter("animalID", newAnimalID).addParameter("locationID", newLocationID).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from sightings WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllSightings() {
        String sql = "DELETE from sightings";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
