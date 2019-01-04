package dao.iml;

import dao.NoticeDao;
import domain.Notice;
import utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class NoticeDaoIml implements NoticeDao {

    @Override
    public void add(Notice notice) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into notice(title,content,admin_id,dormitory_id,created_at) values(?,?,?,?,?)";
            Object params[] = {notice.getTitle(),notice.getContent(),notice.getAdmin_id(),notice.getDormitory_id(),notice.getCreated_at()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete notice where id=?";
            runner.update(sql, id);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Notice find(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from notice where id=?";
            return (Notice) runner.query(sql, id, new BeanHandler(Notice.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Notice> findAll(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from notice where dormitory_id=?";
            List<Notice> list = (List<Notice>) runner.query(sql, dormitory_id, new BeanListHandler(Notice.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int sum(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from notice";
            return (int) runner.query(sql, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
