package dao;

import models.Endangered_Animal;

import java.util.List;

public interface EndangeredAnimalDao {
    //List
    List<Endangered_Animal> getAll();

    //Create
    void add(Endangered_Animal endangered_animal);

    //Read
    Endangered_Animal findById(int id);

    //Update
    void update(int id, String type, String name, String age, String health);

    //Delete
    void deleteById(int id);
    void clearAllEndangeredAnimals();
}
