package models;

import java.util.Objects;

public class Common_Animal {
    private int id;
    public static String type="common";
    private String name;
    private String age;

    public Common_Animal(String type, String name, String age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Common_Animal that = (Common_Animal) o;
        return id == that.id && name.equals(that.name) && age.equals(that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
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

    public void setId(int id) {
        this.id = id;
    }

    public static void setType(String type) {
        Common_Animal.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
