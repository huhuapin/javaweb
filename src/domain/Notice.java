package domain;

import java.sql.Timestamp;

public class Notice {

    private int id;
    private String title;
    private String content;
    private int admin_id;
    private int dormitory_id;
    private Timestamp created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getDormitory_id() {
        return dormitory_id;
    }

    public void setDormitory_id(int dormitory_id) {
        this.dormitory_id = dormitory_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
