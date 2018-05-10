package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Damage;

public interface DamageDao extends BaseDao<Damage> {
	
	List<Damage> readOrderDamages(int orderId);
	List<Integer> readUniqueOrdersId(int carId);
	
//	List<Damages> readCarDamageHistory(int carId);
	
	int countOrderDamageAmount(int orderId);
	
	

}
