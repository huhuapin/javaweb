package dao;

import domain.User;

import java.util.List;

public interface UserDao {

    public void add(User user);      //添加新用户
    public void update(User user);   //更新用户信息
    public void delete(int id);      //删除一个用户
    public User find(int id);        //根据用户id找到用户
    public User find(String username, String password); //根据用户名和密码找到用户
    public List<User> findAll(int page, int limit);     //得到指定页数的所有用户(系统管理员权限)
    public List<User> findAll(int dormitory_id, int page, int limit);  //根据宿舍号返回指定页数的用户
    public boolean existUser(String username);          //通过用户名用户判断是否存在
    public long sum();                                  //返回系统里所有的学生数
    public long sum(int dormitory_id);                  //根据宿舍号返回用户总数
    public List<User> getRoommate(User user);           //返回指定用户的舍友

}
