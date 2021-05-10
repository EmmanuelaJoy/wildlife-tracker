package dao;

import models.Location;
import models.Ranger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLocationDao implements LocationDao{

    private final Sql2o sql2o;

    public Sql2oLocationDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Location> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM locations").executeAndFetch(Location.class);
        }
    }

    @Override
    public void add(Location location) {
        String sql = "INSERT INTO locations (name) VALUES (:name)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(location).executeUpdate().getKey();
            location.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Location findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM locations WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Location.class);
        }
    }

    @Override
    public void update(int id, String newName) {
        String sql = "UPDATE locations SET name = :name WHERE id=:id";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).addParameter("name", newName).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from locations WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllLocations() {
        String sql = "DELETE from locations";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
