package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public interface OrderDao extends BaseDao<Order> {
	
	List<Order> readAll();	
	List<Order> readAllWithStatus(OrderStatusEnum orderStatus);
	List<Order> readUserOrders(int userId);
	List<Order> readReservedDatesForCar(int carId);
	

}
