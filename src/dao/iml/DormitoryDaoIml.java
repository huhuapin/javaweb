package dao.iml;

import dao.DormitoryDao;
import domain.Dormitory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.util.List;

public class DormitoryDaoIml implements DormitoryDao {

    @Override
    public List<Dormitory> getAll() {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from dormitory";
            List<Dormitory> list = (List<Dormitory>) runner.query(sql, new BeanListHandler(Dormitory.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dormitory find(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from dormitory where id=?";
            return (Dormitory) runner.query(sql, id, new BeanHandler(Dormitory.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
