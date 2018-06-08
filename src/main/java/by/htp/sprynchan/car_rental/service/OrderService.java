package by.htp.sprynchan.car_rental.service;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

/**
 * Interface provides methods
 * for working with Order entity.
 * 
 * @author Aleksey Sprynchan
 *
 */
public interface OrderService {
	
	/**
	 * Gets all orders
	 * 
	 * @return List of orders
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Order> getOrderList() throws ServiceException;
	
	/**
	 * Gets orders by certain status
	 * 
	 * @param orderStatus
	 * @return List of orders with specific status
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Order> getOrderListByStatus(OrderStatusEnum orderStatus) throws ServiceException;
	
	/**
	 * Adds new order
	 * 
	 * @param order
	 * @return 0 of adding is successful
	 * @throws ServiceException if DAOException was thrown
	 */
	int createNewOrder (Order order) throws ServiceException;	
	
	/**
	 * Gets order by id
	 * 
	 * @param id
	 * @return Order entity
	 * @throws ServiceException if DAOException was thrown
	 */
	Order getOrder(int id) throws ServiceException;	
	
	/**
	 * Updates order status
	 * 
	 * @param id
	 * @param orderStatus
	 * @throws ServiceException if DAOException was thrown
	 */
	void updateOrderStatus(int id, OrderStatusEnum orderStatus) throws ServiceException;	
	
	/**
	 * Sets rejection reason for order
	 * 
	 * @param id
	 * @param reason
	 * @throws ServiceException if DAOException was thrown
	 */
	void rejectOrder(int id, String reason) throws ServiceException;	
	
	/**
	 * Sets damage amount for certain order
	 * 
	 * @param id
	 * @param totalAmount
	 * @throws ServiceException if DAOException was thrown
	 */
	void sendDamagesAmount(int id, int totalAmount) throws ServiceException;	
	
	/**
	 * Gets all orders of certain user
	 * 
	 * @param userId
	 * @return List of users orders
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Order> getUserOrderList(int userId) throws ServiceException;	
	
	/**
	 * Checks if user unfinished and unpaid orders
	 * 
	 * @param userId
	 * @return false if users does not have unfinished orders
	 * @throws ServiceException if DAOException was thrown
	 */
	boolean checkForUnfinishedOrders (int userId) throws ServiceException;	
	
	/**
	 * Gets list of dates for which car is unavailable
	 * 
	 * @param carId
	 * @return List of dates
	 * @throws ServiceException if DAOException was thrown
	 */
	List<String> getResevedDatesList(int carId) throws ServiceException;
}
