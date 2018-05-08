package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.DamageHistory;

public interface DamageHistoryDao extends BaseDao<DamageHistory> {
	
	List<DamageHistory> readAllCarDamHist(int carId);

}
