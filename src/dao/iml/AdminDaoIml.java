package dao.iml;

import dao.AdminDao;
import domain.Admin;
import utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AdminDaoIml implements AdminDao {

    @Override
    public void add(Admin admin) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into admin(username,password,name,dormitory_id,user_id) values(?,?,?,?,?)";
            Object params[] = {admin.getUsername(),admin.getPassword(),admin.getName(),admin.getDormitory_id(),admin.getStatus()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(int id, String password) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update admin set password=? where id=?";
            runner.update(sql, password, id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void status(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update admin set status=1 where id=?";
            runner.update(sql, id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Admin find(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from admin where id=?";
            return (Admin) runner.query(sql, id, new BeanHandler(Admin.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Admin find(String username, String password) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from admin where username=? and password=?";
            Object params[] = {username, password};
            return (Admin) runner.query(sql, params, new BeanHandler(Admin.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Admin> getAll() {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from admin;";
            List<Admin> list = (List<Admin>) runner.query(sql, new BeanListHandler(Admin.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum() {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from admin";
            return (long) runner.query(sql, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String show(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select description from dormitory where id=?";
            return (String) runner.query(sql, dormitory_id, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
