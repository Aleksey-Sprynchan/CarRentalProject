package by.htp.sprynchan.car_rental.service;



import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public interface OrderService {
	
	List<Order> getOrderList(OrderStatusEnum orderStatus);
	
	int createNewOrder (Order order);
	
	Order getOrder(int id);
	
	void updateOrderStatus(int id, OrderStatusEnum orderStatus);
	
	
	void rejectOrder(int id, String reason);
	
	void sendDamagesAmount(int id, int totalAmount);
	
	List<Order> getUserOrderList(int userId);
	
	boolean checkForUnfinishedOrders (int userId);
	
	List<String> getResevedDatesList(int carId);
	
	
	

}
