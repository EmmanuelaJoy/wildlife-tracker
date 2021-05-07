package dao;

import models.Ranger;

import java.util.List;

public interface RangerDao {

    //List
    List<Ranger> getAll();

    //Create
    void add(Ranger ranger);

    //Read
    Ranger findById(int id);

    //Update
    void update(int id, String name, int badge_number, int phone_number, String email);

    //Delete
    void deleteById(int id);
    void clearAllTasks();
}
