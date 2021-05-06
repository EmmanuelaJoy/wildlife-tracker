package models;

import java.util.ArrayList;

public class Endangered_Animal {
    private static int id;
    public static String type="endangered";
    private String name;
    private String age;
    private String health_status;
    private static ArrayList<Endangered_Animal> endangered_animals = new ArrayList<>();

    public Endangered_Animal(String type, String name, String age, String health_status){
        this.type= type;
        this.name = name;
        this.age = age;
        this.health_status = health_status;
        endangered_animals.add(this);
        this.id = endangered_animals.size();
    }
}
