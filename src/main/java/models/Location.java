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
}
