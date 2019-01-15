package dao.iml;

import dao.UserDao;
import domain.User;
import utils.*;

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
            String sql = "insert into user(username,password,name,nickname,image,_class,dormitory_id,room) values(?,?,?,?,?,?,?,?)";
            Object params[] = {user.getUsername(),MD5Utils.md5(MD5Utils.md5(user.getPassword())),user.getName(),user.getNickname(),user.getImage(),user.get_class(),user.getDormitory_id(),user.getRoom()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(int id, String password) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update user set password=? where id=?";
            runner.update(sql, MD5Utils.md5(MD5Utils.md5(password)), id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update user set name=?,_class=?,dormitory_id=?,room=? where id=?;";
            Object params[] = {user.getName(),user.get_class(),user.getDormitory_id(),user.getRoom(),user.getId()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from user where id=?;";
            runner.update(sql, id);
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
            Object params[] = {username, MD5Utils.md5(MD5Utils.md5(password))};
            return (User) runner.query(sql, params, new BeanHandler(User.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll(int dormitory_id, int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where dormitory_id=? order by id limit ?,?";
            Object params[] = {dormitory_id, page, limit};
            List<User> list = (List<User>) runner.query(sql, params, new BeanListHandler(User.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll(int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user order by id limit ?,?";
            Object params[] = {page, limit};
            List<User> list = (List<User>) runner.query(sql, params, new BeanListHandler(User.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existUser(String username) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where username=?";
            User user = (User) runner.query(sql,username,new BeanHandler(User.class));
            if (user == null) {
                return false;
            }
            return true;
        }catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public long sum(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from user where dormitory_id=?";
            return (long) runner.query(sql, dormitory_id, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum() {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from user";
            return (long) runner.query(sql, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getRoommate(User user) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where dormitory_id = ? and room = ?";
            Object params[] = {user.getDormitory_id(),user.getRoom()};
            return (List<User>) runner.query(sql,params,new BeanListHandler(User.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
