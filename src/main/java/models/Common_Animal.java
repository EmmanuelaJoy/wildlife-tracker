package models;

import java.util.ArrayList;

public class Common_Animal {
    private int id;
    public static String type="common";
    private String name;
    private String age;
    private static ArrayList<Common_Animal> common_animals = new ArrayList<>();

    public Common_Animal(String type, String name, String age) {
        this.type = type;
        this.name = name;
        this.age = age;
        common_animals.add(this);
        this.id = common_animals.size();
    }
}
