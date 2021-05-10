package models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Sighting {
    private int id;
    private int ranger_id;
    private int animal_id;
    private int location_id;
    private Date date = new Date();
    private Timestamp time;

    public Sighting(int ranger_id, int animal_id, int location_id){
        this.ranger_id = ranger_id;
        this.animal_id = animal_id;
        this.location_id = location_id;
        this.time = new Timestamp(date.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return id == sighting.id && ranger_id == sighting.ranger_id && animal_id == sighting.animal_id && location_id == sighting.location_id && date.equals(sighting.date) && time.equals(sighting.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ranger_id, animal_id, location_id, date, time);
    }

    public int getId() {
        return id;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public Date getDate() {
        return date;
    }

    public Timestamp getTimestamp() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRanger_id(int ranger_id) {
        this.ranger_id = ranger_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.time = timestamp;
    }
}
