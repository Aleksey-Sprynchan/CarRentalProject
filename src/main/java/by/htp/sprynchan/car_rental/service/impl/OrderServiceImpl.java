package by.htp.sprynchan.car_rental.service.impl;



import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.dao.impl.OrderDaoImpl;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();

	@Override
	public void createNewOrder(Order order) {

		orderDao.create(order);

	}

	@Override
	public Order getOrder(int id) {
		
		return orderDao.read(id);
	}

	@Override
	public void updateOrderStatus(int id, OrderStatusEnum orderStatus) {
		
		Order order = orderDao.read(id);
		order.setStatus(orderStatus);
		orderDao.update(order);
		
	}

	@Override
	public Order executeInstantRead(Order order) {
		
		return orderDao.instantRead(order);
		
	}

	@Override
	public List<Order> getOrderList(OrderStatusEnum orderStatus) {
		List<Order> orders = new ArrayList<>();
		if (orderStatus != null) {
			orders = orderDao.readAllWithStatus(orderStatus);
		} else {
			orders = orderDao.readAll();
		}
		return orders;
	}

	@Override
	public void rejectOrder(int id, String reason) {
		
		Order order = orderDao.read(id);
		order.setStatus(OrderStatusEnum.CANCELLED);
		order.setRejectionReason(reason);
		orderDao.update(order);
		
	}

	@Override
	public void sendDamagesAmount(int id, String[] damageValues) {
		
		Order order = orderDao.read(id);
		int finalAmount = 0;
		for(String value: damageValues) {
			finalAmount = finalAmount + Integer.parseInt(value);
		}
		order.setDamaged(true);
		order.setStatus(OrderStatusEnum.WAITING_FOR_DAMAGE_PAYMENT);
		order.setDamageAmount(finalAmount);
		orderDao.update(order);
	
	}

	@Override
	public List<Order> getUserOrderList(int id) {
		List<Order> orders = new ArrayList<>();
		
		for(Order order: orderDao.readAll()) {
			if(order.getUserId() == id) {
				orders.add(order);
			}
		}
		
		return orders;
	}

}
