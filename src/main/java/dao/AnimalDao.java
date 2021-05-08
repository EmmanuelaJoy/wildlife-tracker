package dao;

import models.Common_Animal;

import java.util.List;

public interface AnimalDao {
    //List
    List<Common_Animal> getAll();

    //Create
    void add(Common_Animal common_animal);

    //Read
    Common_Animal findById(int id);

    //Update
    void update(int id, String type, String name, String age);

    //Delete
    void deleteById(int id);
    void clearAllAnimals();
}
