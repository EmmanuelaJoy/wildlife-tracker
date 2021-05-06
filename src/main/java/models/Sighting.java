package models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Sighting {
    private int id;
    private int rangerID;
    private int animalID;
    private int locationID;
    private Date date = new Date();
    private Timestamp timestamp;

    public Sighting(int rangerID, int animalID, int locationID){
        this.rangerID = rangerID;
        this.animalID = animalID;
        this.locationID = locationID;
        this.timestamp = new Timestamp(date.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id && rangerID == sighting.rangerID && animalID == sighting.animalID && locationID == sighting.locationID && date.equals(sighting.date) && timestamp.equals(sighting.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rangerID, animalID, locationID, date, timestamp);
    }

    public int getId() {
        return id;
    }

    public int getRangerID() {
        return rangerID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public int getLocationID() {
        return locationID;
    }

    public Date getDate() {
        return date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRangerID(int rangerID) {
        this.rangerID = rangerID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
