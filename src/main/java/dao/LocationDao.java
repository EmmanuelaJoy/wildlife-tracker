package dao;

import models.Location;

import java.util.List;

public interface LocationDao {
    //List
    List<Location> getAll();

    //Create
    void add(Location location);

    //Read
    Location findById(int id);

    //Update
    void update(int id, String name);

    //Delete
    void deleteById(int id);
    void clearAllLocations();
}
