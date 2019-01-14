package domain;

import java.sql.Timestamp;

public class Funds {
    private int id;//自增id，主键
    private String description;//花费描述
    private int user_id;//操作用户id
    private String name;//操作用户名
    private double money;//操作金额
    private Timestamp created_at;//创建时间
    private int dormirory_id;//公寓楼号
    private int room;//房间号
    private double balance;//操作后的余额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getDormirory_id() {
        return dormirory_id;
    }

    public void setDormirory_id(int dormirory_id) {
        this.dormirory_id = dormirory_id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
