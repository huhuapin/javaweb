package dao.iml;

import dao.RepairDao;
import domain.Repair;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import utils.JdbcUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairDaoIml implements RepairDao {

    @Override
    public List<Repair> findAll(int page, int limit) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from repair order by created_at desc limit ?,?";
            return runner.query(sql,new BeanListHandler<Repair>(Repair.class),page,limit);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Repair> findAll(int dormitory, int page, int limit) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from repair where dormitory_id = ? order by created_at desc limit ?,?";
            return runner.query(sql,new BeanListHandler<Repair>(Repair.class),dormitory,page,limit);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateRepair(Repair repair) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update repair set reason = ?,address = ?,image = ?,detail = ?,tel = ?,message = ?,status = ?,rate = ? where id = ?";
            Object[] params = {repair.getReason(),repair.getAddress(), JSONArray.fromObject(repair.getImage()).toString(),repair.getDetail(),repair.getTel(),repair.getMessage(),repair.getStatus(),repair.getRate(),repair.getId()};
            return runner.update(sql,params);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

}

    @Override
    public int deleteRepair(int id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from repair where id = ?";
            return runner.update(sql,new BeanListHandler<Repair>(Repair.class),id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Repair find(int id) {
        try {
            Map<String, Object> map = new HashMap<String,Object>();
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from repair where id = ?";
            map = runner.query(sql,new MapHandler(),id);
            Repair repair = runner.query(sql,new BeanHandler<Repair>(Repair.class),id);
            repair.setImage((String) map.get("image"));
            return repair;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addRepair(Repair repair) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into repair(reason,address,image,detail,tel,user_id,dormitory_id,status,created_at,updated_at)" +
                    "values(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {repair.getReason(),repair.getAddress(), JSONArray.fromObject(repair.getImage()).toString(),repair.getDetail(),repair.getTel(),repair.getUser_id(),repair.getDormitory_id(),0,repair.getCreated_at(),repair.getCreated_at()};
            return runner.update(sql,params);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Repair> findByUserId(int user_id, int page, int limit) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from repair where user_id = ? order by updated_at desc limit ?,?";
            return runner.query(sql,new BeanListHandler<Repair>(Repair.class),user_id,page,limit);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
