package dao;

import domain.Admin;

import java.util.List;

public interface AdminDao {

    public void add(Admin admin);                       //添加新的管理员
    public void modify(int id, String password);        //修改密码
    public Admin find(int id);                          //根据id找到管理员
    public Admin find(String username, String password);//根据用户名和密码找到管理员
    public List<Admin> findAll(int page, int limit);    //返回指定页数的管理员
    public  boolean existAdmin(String username);        //通过用户名用户判断是否存在
    public long sum();                                  //返回所有管理员的数量
    public String show(int dormitory_id);               //返回管理员所在的宿舍楼

}
