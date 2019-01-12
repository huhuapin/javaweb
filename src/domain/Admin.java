package domain;

import dao.DormitoryDao;
import dao.iml.DormitoryDaoIml;

public class Admin {

    private int id;
    private String username;
    private String password;
    private String name;
    private int dormitory_id;
    private String tel;
    private boolean root;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDormitory_id() {
        return dormitory_id;
    }

    public void setDormitory_id(int dormitory_id) {
        this.dormitory_id = dormitory_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public String getDescription() {
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        return dormitoryDao.find(dormitory_id).getDescription();
    }

}
