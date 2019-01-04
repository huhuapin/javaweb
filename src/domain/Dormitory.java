package domain;

import java.sql.Timestamp;

public class Dormitory {

    private int id;
    private String name;
    private String description;
    private int school;
    private String elec_name;
    private Timestamp created__at;
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public String getElec_name() {
        return elec_name;
    }

    public void setElec_name(String elec_name) {
        this.elec_name = elec_name;
    }

    public Timestamp getCreated__at() {
        return created__at;
    }

    public void setCreated__at(Timestamp created__at) {
        this.created__at = created__at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
