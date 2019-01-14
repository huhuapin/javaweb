package dao;

import domain.Repair;

import java.util.List;

public interface RepairDao {
    public List<Repair> findAll(int page,int limit);                 //获取全部报修信息
    public List<Repair> findAll(int dormitory,int page,int limit);   //获取指定宿舍的报修信息
    public int updateRepair(Repair repair);  //更新报修信息
    public int deleteRepair(int id);         //通过id删除报修信息
    public int addRepair(Repair repair);     //添加报修信息
    public List<Repair> findByUserId(int user_id,int page,int limit);//获取指定用户的报修记录
    public Repair find(int id);              //根据id查询记录
    public long sum();                       //返回所有的保修记录数
    public long sum(int dormitory_id);       //根据宿舍楼号返回所有保修记录数量
}
