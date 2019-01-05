package dao;

import domain.Dormitory;

import java.util.List;

public interface DormitoryDao {

    public List<Dormitory> getAll();    //返回所有的宿舍楼
    public String getElec_name(int id); //根据宿舍楼id返回elec_name

}
