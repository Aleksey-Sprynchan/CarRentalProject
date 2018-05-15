package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public interface OrderDao extends BaseDao<Order> {
	
	List<Order> readAll() throws DAOException;	
	List<Order> readAllWithStatus(OrderStatusEnum orderStatus) throws DAOException;
	List<Order> readUserOrders(int userId) throws DAOException;
	List<Order> readReservedDatesForCar(int carId) throws DAOException;
	
}
