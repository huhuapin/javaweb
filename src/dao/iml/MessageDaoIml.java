package dao.iml;

import dao.MessageDao;
import domain.Message;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MessageDaoIml implements MessageDao {

    @Override
    public void add(Message message) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into message(content,praise,dormitory_id,user_id,created_at) values(?,?,?,?,?)";
            Object params[] = {message.getContent(),message.getPraise(),message.getDormitory_id(),message.getUser_id(),message.getCreated_at()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from message where id=?";
            runner.update(sql, id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void praise(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update message set praise=praise+1 where id=?";
            runner.update(sql, id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message find(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from message where id=?";
            return (Message) runner.query(sql,new BeanHandler<Message>(Message.class),id);
//            return (Message) runner.query(sql, id, new BeanHandler(Message.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Message> findAll(int dormitory_id, int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from message where dormitory_id = ? order by created_at desc limit ?,?";
            Object params[] = {dormitory_id, page, limit};
            List<Message> list = (List<Message>) runner.query(sql, params, new BeanListHandler(Message.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from message where dormitory_id = ?";
            return (long) runner.query(sql, dormitory_id, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
