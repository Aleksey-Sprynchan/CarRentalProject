package by.htp.sprynchan.car_rental.service;

import java.util.List;
import java.util.Map;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public interface DamageService {
	
	void addDamage(Damage damage) throws ServiceException;
	List<Damage> getOrderDamages(int orderId) throws ServiceException;
	Map<Integer, List<Damage>> getCarDamageHistory(int carId) throws ServiceException;	
	int getTotalDamageAmount(int orderId) throws ServiceException;
}
