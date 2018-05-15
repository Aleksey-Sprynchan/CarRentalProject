package by.htp.sprynchan.car_rental.service;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public interface OrderService {
	
	List<Order> getOrderList(OrderStatusEnum orderStatus) throws ServiceException;	
	int createNewOrder (Order order) throws ServiceException;	
	Order getOrder(int id) throws ServiceException;	
	void updateOrderStatus(int id, OrderStatusEnum orderStatus) throws ServiceException;	
	void rejectOrder(int id, String reason) throws ServiceException;	
	void sendDamagesAmount(int id, int totalAmount) throws ServiceException;	
	List<Order> getUserOrderList(int userId) throws ServiceException;	
	boolean checkForUnfinishedOrders (int userId) throws ServiceException;	
	List<String> getResevedDatesList(int carId) throws ServiceException;
}
