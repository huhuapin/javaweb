package dao.iml;

import dao.AdminDao;
import domain.Admin;
import utils.*;

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
            String sql = "insert into admin(username,password,name,dormitory_id,tel) values(?,?,?,?,?)";
            Object params[] = {admin.getUsername(),MD5Utils.md5(admin.getPassword()),admin.getName(),admin.getDormitory_id(),admin.getTel()};
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
            runner.update(sql, MD5Utils.md5(password), id);
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
            Object params[] = {username, MD5Utils.md5(password)};
            return (Admin) runner.query(sql, params, new BeanHandler(Admin.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Admin> findAll(int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from admin order by id limit ?,?";
            Object params[] = {page, limit};
            List<Admin> list = (List<Admin>) runner.query(sql, params, new BeanListHandler(Admin.class));
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
    public boolean existAdmin(String username) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from admin where username=?";
            Admin admin = (Admin) runner.query(sql,username,new BeanHandler<>(Admin.class));
            if (admin == null) {
                return false;
            }
            return true;
        }catch (Exception e) {
            throw  new RuntimeException(e);
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
