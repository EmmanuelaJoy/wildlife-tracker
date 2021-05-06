package models;

import java.util.ArrayList;

public class Location {
    private static int id;
    private String name;
    private static ArrayList<Location> locations = new ArrayList<>();

    public Location(String name){
        this.name=name;
        locations.add(this);
        this.id = locations.size();
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

    public static void clearAllLocations() {
        locations.clear();
    }
}
