package dao;

import domain.Admin;

import java.util.List;

public interface AdminDao {

    public void add(Admin admin);   //添加新的管理员
    public void status(int id);     //更改管理员的审核状态
    public Admin find(int id);      //根据id找到管理员
    public Admin find(String username, String password); //根据用户名和密码找到管理员
    public List<Admin> getAll();    //返回所有管理员
    public int sum();               //返回所有管理员的数量

}
