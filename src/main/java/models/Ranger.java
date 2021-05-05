package models;

import java.util.ArrayList;

public class Ranger {
    private static int id;
    private String name;
    private int badge_number;
    private int phone_number;
    private String email;
    private static ArrayList<Ranger> rangers = new ArrayList<>();

    public Ranger(String name, int badge_number, int phone_number, String email){
        this.name = name;
        this.badge_number = badge_number;
        this.phone_number = phone_number;
        this.email = email;
        rangers.add(this);
        this.id = rangers.size();
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBadge_number() {
        return badge_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public static ArrayList<Ranger> getRangers() {
        return rangers;
    }
}
