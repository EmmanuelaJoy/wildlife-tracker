package models;
import java.util.Objects;

public class Ranger {
    private int id;
    private String name;
    private int badge_number;
    private int phone_number;
    private String email;
    public Ranger(String name, int badge_number, int phone_number, String email){
        this.name = name;
        this.badge_number = badge_number;
        this.phone_number = phone_number;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranger ranger = (Ranger) o;
        return badge_number == ranger.badge_number && phone_number == ranger.phone_number && name.equals(ranger.name) && email.equals(ranger.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, badge_number, phone_number, email);
    }

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBadge_number(int badge_number) {
        this.badge_number = badge_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
