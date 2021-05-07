package dao;
import models.Ranger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Sql2oRangerDao implements RangerDao {
    private final Sql2o sql2o;

    public Sql2oRangerDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Ranger> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM rangers").executeAndFetch(Ranger.class);
        }
    }

    @Override
    public void add(Ranger ranger) {
        String sql = "INSERT INTO rangers (name) VALUES (:name)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(ranger).executeUpdate().getKey();
            ranger.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Ranger findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM rangers WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Ranger.class);
        }
    }

    @Override
    public void update(int id, String name, int badge_number, int phone_number, String email) {
        String sql = "UPDATE rangers SET name = :name WHERE id=:id";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).addParameter("name", name).addParameter("id", id).executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from rangers WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllRangers() {
        String sql = "DELETE from rangers";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
