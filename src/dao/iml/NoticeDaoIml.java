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
            Integer dormitory_id = notice.getDormitory_id();
            if(notice.getDormitory_id() == 0) dormitory_id = null;
            System.out.println(dormitory_id);
            Object params[] = {notice.getTitle(),notice.getContent(),notice.getAdmin_id(),dormitory_id,notice.getCreated_at()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(Notice notice) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update notice set title=?,content=?,created_at=? where id=?";
            Object params[] = {notice.getTitle(),notice.getContent(),notice.getCreated_at(),notice.getId()};
            runner.update(sql, params);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from notice where id=?";
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
    public List<Notice> findAll(int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from notice order by created_at desc limit ?,?";
            Object params[] = {page, limit};
            List<Notice> list = (List<Notice>) runner.query(sql, params, new BeanListHandler(Notice.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Notice> findAll(int dormitory_id, int page, int limit) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from notice where dormitory_id = ? or dormitory_id is null order by created_at desc limit ?,?";
            Object params[] = {dormitory_id, page, limit};
            List<Notice> list = (List<Notice>) runner.query(sql, params, new BeanListHandler(Notice.class));
            return list;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from notice where dormitory_id = ? or dormitory_id is null";
            return (long) runner.query(sql, dormitory_id, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long sum() {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from notice";
            return (long) runner.query(sql, new ScalarHandler());
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Notice getFirst(int dormitory_id) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from notice where dormitory_id = ? or dormitory_id is null order by created_at desc limit 1";
            return (Notice) runner.query(sql,dormitory_id, new BeanHandler(Notice.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
