package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

/**
 * Interface that provides additional methods 
 * to access order data from database.
 * 
 * @author Aleksey Sprynchan
 */
public interface OrderDao extends BaseDao<Order> {
	
	/**
	 * Gets all existing orders from database
	 * 
	 * @return List of orders
	 * @throws DAOException
	 */
	List<Order> readAll() throws DAOException;	
	
	/**
	 * Gets orders with certain status from database
	 * 
	 * @param orderStatus
	 * @return List of orders
	 * @throws DAOException
	 */
	List<Order> readAllWithStatus(OrderStatusEnum orderStatus) throws DAOException;
	
	/**
	 * Gets all user orders from database
	 * 
	 * @param userId
	 * @return List of orders
	 * @throws DAOException
	 */
	List<Order> readUserOrders(int userId) throws DAOException;
	
	/**
	 * Reads rental dates for certain car
	 * 
	 * @param carId
	 * @return List of orders with reserved dates
	 * @throws DAOException
	 */
	List<Order> readReservedDatesForCar(int carId) throws DAOException;
	
}
