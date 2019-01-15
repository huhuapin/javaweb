package dao.iml;

import dao.FundsDao;
import domain.Funds;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.util.List;

public class FundsDaolml implements FundsDao {
    @Override
    public int addFunds(Funds funds){
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into funds(id,description,user_id,name,money,created_at,dormitory_id,room,balance)" +
                    "values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {funds.getId(),funds.getDescription(),funds.getUser_id(),funds.getName(),funds.getMoney(),funds.getCreated_at(),funds.getDormirory_id(),funds.getRoom(),funds.getBalance()};
            return runner.update(sql,params);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Funds> findByRoomId(int dormitory_id, int room,int page,int limit){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from funds where dormitory_id = ? and room = ? order by created_at desc limit ?,?";
            return runner.query(sql,new BeanListHandler<Funds>(Funds.class),dormitory_id,room,page,limit);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public double sumBalance(int dormitory_id, int room){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select sum(money) from funds where dormitory_id = ? and room = ?";
            Object object = runner.query(sql, new ScalarHandler(), dormitory_id,room);
            if(object == null){
                return 0;
            }
            return (double)object;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum(int dormitory_id, int room) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from funds where dormitory_id = ? and room = ?";
            Object[] params = {dormitory_id, room};
            return (long) runner.query(sql, new ScalarHandler(),params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
