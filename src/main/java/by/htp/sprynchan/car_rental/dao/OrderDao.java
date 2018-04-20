package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public interface OrderDao extends BaseDao<Order> {
	
	List<Order> readAll();
	
	List<Order> readAllWithStatus(OrderStatusEnum orderStatus);
	
//	Order instantRead(Order order);
	
	int getLastInsertId();
	
	int createOrderTransaction(Order entity);

}
