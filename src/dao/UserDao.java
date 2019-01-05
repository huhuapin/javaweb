package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    public void add(User user);      //添加新用户
    public void update(User user);   //更新用户信息
    public void delete(int id);      //删除一个用户
    public User find(int id);        //根据用户id找到用户
    public User find(String username, String password); //根据用户名和密码找到用户
    public List<User> findAll(int dormitory_id);        //根据宿舍号返回所有用户
    public long sum(int dormitory_id);//根据宿舍号返回用户总数
    public List<User> getRoommate(User user);

}
