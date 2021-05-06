package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Sighting {
    private static int id;
    private int rangerID;
    private int animalID;
    private int locationID;
    private Date date = new Date();
    private Timestamp timestamp;
    private static ArrayList<Sighting> sightings = new ArrayList<>();

    public Sighting(int rangerID, int animalID, int locationID){
        this.rangerID = rangerID;
        this.animalID = animalID;
        this.locationID = locationID;
        this.timestamp = new Timestamp(date.getTime());
        this.id = sightings.size();
    }

}
