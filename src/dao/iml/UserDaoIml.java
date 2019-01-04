package dao.iml;

import dao.UserDao;
import domain.User;
import utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UserDaoIml implements UserDao {

    @Override
    public void add(User user) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into user(username,password,nickname,image,_class,dormitory_id,room) values(?,?,?,?,?,?,?)";
            Object params[] = {user.getUsername(),user.getPassword(),user.getNickname(),user.getImage(),user.get_class(),user.getDormitory_id(),user.getRoom()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update user set password=?,nickname=?,image=?,_class=?,dormitory_id=?,room=? where id=?;";
            Object params[] = {user.getPassword(),user.getNickname(),user.getImage(),user.get_class(),user.getDormitory_id(),user.getRoom(),user.getId()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where id=?";
            return (User) runner.query(sql, id, new BeanHandler(User.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(String username, String password) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where username=? and password=?";
            Object params[] = {username, password};
            return (User) runner.query(sql, params, new BeanHandler(User.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where dormitory_id=?;";
            List<User> list = (List<User>) runner.query(sql, dormitory_id, new BeanListHandler(User.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int sum(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from user where dormitory_id=?";
            return (int) runner.query(sql, dormitory_id, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
