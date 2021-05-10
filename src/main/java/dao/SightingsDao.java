package dao;

import models.Sighting;

import java.util.List;

public interface SightingsDao {
    //List
    List<Sighting> getAll();

    //Create
    void add(Sighting sighting);

    //Read
    Sighting findById(int id);

    //Update
    void update(int id, int rangerID, int animalID, int locationID);

    //Delete
    void deleteById(int id);
    void clearAllSightings();
}
