package domain;

import dao.DormitoryDao;
import dao.UserDao;
import dao.iml.DormitoryDaoIml;
import dao.iml.UserDaoIml;
import utils.JSONUtils;

import java.sql.Timestamp;
import java.util.Arrays;

public class Repair {
    private int id;  //自增id，主键
    private String reason;  //报修原因
    private String address; //地点
    private String[] image; //图片
    private String detail; //报修详情
    private String tel;  //联系电话
    private int user_id;  //报修人
    private int dormitory_id; //报修宿舍
    private String message; //回复消息
    private int status;  //报修状态  0待完成   1正在进行   2 已完成
    private int rate; //评分
    private Timestamp created_at; //创建时间
    private Timestamp updated_at; //修改时间
    private User user;   //用户

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    private Dormitory dormitory;  //宿舍
    private int image_length; //照片的数量

    public int getImage_length() {
        if (image_length == 0) {
            this.setImage_length();
        }
        return image_length;
    }

    public void setImage_length() {
        this.image_length = this.image.length;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setAddress(String address) {
        System.out.println("Set Address:" + address);
        this.address = address;
    }

    public void setImage(String image) {
        System.out.println("String image:" + image);
        this.image = JSONUtils.toStringArray(image);
        System.out.println("String[] image:" + Arrays.toString(this.image));
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTel(String tel) {
        System.out.println("setTel:" + tel);
        this.tel = tel;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDormitory_id(int dormotiry_id) {
        this.dormitory_id = dormotiry_id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUser() {
        UserDao userDao = new UserDaoIml();
        this.user = userDao.find(this.user_id);
    }

    public void setDormitory() {
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        this.dormitory = dormitoryDao.find(this.dormitory_id);
    }

    public int getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public String getAddress() {
        return address;
    }

    public String[] getImage() {
        return image;
    }

    public String getDetail() {
        return detail;
    }

    public String getTel() {
        return tel;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getDormitory_id() {
        return dormitory_id;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        if (user == null) {
            this.setUser();
        }
        return user;
    }

    public Dormitory getDormitory() {
        if (dormitory == null) {
            this.setDormitory();
        }
        return dormitory;
    }
}
