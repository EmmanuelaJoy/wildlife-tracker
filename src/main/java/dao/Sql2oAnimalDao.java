package dao;
import models.Common_Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Sql2oAnimalDao implements AnimalDao {
    private final Sql2o sql2o;

    public Sql2oAnimalDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public List<Common_Animal> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM common_animals").executeAndFetch(Common_Animal.class);
        }
    }

    @Override
    public void add(Common_Animal common_animal) {
        String sql = "INSERT INTO common_animals (type , name , age) VALUES (:type , :name , :age)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(common_animal).executeUpdate().getKey();
            common_animal.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Common_Animal findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM common_animals WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Common_Animal.class);
        }
    }

    @Override
    public void update(int id, String newType, String newName, String newAge) {
        String sql = "UPDATE common_animals SET type= :type, name = :name, age = :age WHERE id=:id";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).addParameter("id", id).addParameter("type", newType).addParameter("name", newName).addParameter("age", newAge).executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from common_animals WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllAnimals() {
        String sql = "DELETE from common_animals";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
