package models;

import java.util.Objects;

public class Endangered_Animal {
    private int id;
    public static String type="endangered";
    private String name;
    private String age;
    private String health_status;

    public Endangered_Animal(String type, String name, String age, String health_status){
        this.type= type;
        this.name = name;
        this.age = age;
        this.health_status = health_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endangered_Animal that = (Endangered_Animal) o;
        return id == that.id && name.equals(that.name) && age.equals(that.age) && health_status.equals(that.health_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, health_status);
    }

    public int getId() {
        return id;
    }

    public static String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setType(String type) {
        Endangered_Animal.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }
}
