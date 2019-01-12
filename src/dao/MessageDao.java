package dao;

import domain.Message;

import java.util.List;

public interface MessageDao {

    public void add(Message message);   //添加一条留言
    public void delete(int id);         //根据留言id删除一条留言
    public void praise(int id);         //根据留言id增加点赞数
    public Message find(int id);        //根据留言id返回一条留言
    public List<Message> findAll(int dormitory_id, int page, int limit); //根据宿舍楼号返回指定页数的留言
    public long sum(int dormitory_id);  //根据宿舍楼号返回所有留言数量

}
