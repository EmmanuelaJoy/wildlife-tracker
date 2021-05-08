package models;

import java.util.Objects;

public class Endangered_Animal {
    private int id;
    public String type;
    private String name;
    private String age;
    private String health;

    public Endangered_Animal(String type, String name, String age, String health){
        this.type= type;
        this.name = name;
        this.age = age;
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endangered_Animal that = (Endangered_Animal) o;
        return id == that.id && name.equals(that.name) && age.equals(that.age) && health.equals(that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, health);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth_status() {
        return health;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}
