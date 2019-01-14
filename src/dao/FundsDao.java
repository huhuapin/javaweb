package dao;

import domain.Funds;

import java.util.List;

public interface FundsDao {
    public int addFunds(Funds funds);//添加舍费操作信息
    public List<Funds> findByRoomId(int dormitory_id, int room, int page, int limit);//获取指定宿舍的舍费操作记录
    public double sumBalance(int dormitory_id, int room);//获取当前宿舍的舍费余额
}
