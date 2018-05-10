package by.htp.sprynchan.car_rental.service;

import java.util.List;
import java.util.Map;

import by.htp.sprynchan.car_rental.bean.Damage;

public interface DamageService {
	
	void addDamage(Damage damage);
	
	List<Damage> getOrderDamages(int orderId);
	
	Map<Integer, List<Damage>> getCarDamageHistory(int carId);
	
	int getTotalDamageAmount(int orderId);
	

}
