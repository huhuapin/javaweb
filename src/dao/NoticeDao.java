package dao;

import domain.Notice;

import java.util.List;

public interface NoticeDao {

    public void add(Notice notice);     //增加一条公告
    public void modify(Notice notice);  //修改公告
    public void delete(int id);         //根据公告id删除一条公告
    public Notice find(int id);         //根据公告id找到一条公告
    public List<Notice> findAll(int dormitory_id); //根据宿舍楼号返回所有公告
    public long sum(int dormitory_id);   //根据宿舍楼号返回所有公告数量
}
