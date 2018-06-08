package by.htp.sprynchan.car_rental.service;

import java.util.List;
import java.util.Map;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

/**
 * Interface provides methods
 * for working with Danage entity.
 * 
 * @author Aleksey Sprynchan
 *
 */
public interface DamageService {
	
	/**
	 * Adds damage for car
	 * 
	 * @param damage
	 * @throws ServiceException if DAOException was thrown
	 */
	void addDamage(Damage damage) throws ServiceException;
	
	/**
	 * Gets damages for certain order
	 * 
	 * @param orderId
	 * @return List of order damages
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Damage> getOrderDamages(int orderId) throws ServiceException;
	
	/**
	 * Gets a Map with orders and List of damages 
	 * for these orders
	 * 
	 * @param carId
	 * @return Map of orders with damages
	 * @throws ServiceException if DAOException was thrown
	 */
	Map<Integer, List<Damage>> getCarDamageHistory(int carId) throws ServiceException;	
	
	/** 
	 * Gets total damage amount for certain order
	 * 
	 * @param orderId
	 * @return total damage amount
	 * @throws ServiceException if DAOException was thrown
	 */
	int getTotalDamageAmount(int orderId) throws ServiceException;
	
}
