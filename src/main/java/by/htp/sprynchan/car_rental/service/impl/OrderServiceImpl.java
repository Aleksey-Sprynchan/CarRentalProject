package by.htp.sprynchan.car_rental.service.impl;

import static by.htp.sprynchan.car_rental.service.util.ServiceInputParamNullValidator.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.dao.factory.DAOFactory;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = DAOFactory.getOrderDAO();

	@Override
	public int createNewOrder(Order order) throws ServiceException {
		validateInputParamNotNull(order);
		return orderDao.create(order);
	}

	@Override
	public Order getOrder(int id) throws ServiceException {
		return orderDao.read(id);
	}

	@Override
	public void updateOrderStatus(int id, OrderStatusEnum orderStatus) throws ServiceException {
		validateInputParamNotNull(orderStatus);
		Order order = orderDao.read(id);
		order.setStatus(orderStatus);
		orderDao.update(order);
	}

	@Override
	public List<Order> getOrderList() throws ServiceException {	
			return orderDao.readAll();
	}
	
	@Override
	public List<Order> getOrderListByStatus(OrderStatusEnum orderStatus) throws ServiceException {
		validateInputParamNotNull(orderStatus);
		return orderDao.readAllWithStatus(orderStatus);
	}

	@Override
	public void rejectOrder(int id, String reason) throws ServiceException {
		validateInputParamNotNull(reason);
		Order order = orderDao.read(id);
		order.setStatus(OrderStatusEnum.REJECTED);
		order.setRejectionReason(reason);
		orderDao.update(order);
	}

	@Override
	public void sendDamagesAmount(int id, int totalAmount) throws ServiceException {
		Order order = orderDao.read(id);
		order.setDamaged(true);
		order.setStatus(OrderStatusEnum.WAITING_FOR_DAMAGE_PAYMENT);
		order.setDamageAmount(totalAmount);
		orderDao.update(order);
	}

	@Override
	public List<Order> getUserOrderList(int userId) throws ServiceException {
		return orderDao.readUserOrders(userId);
	}

	@Override
	public boolean checkForUnfinishedOrders(int userId) throws ServiceException {
		List<Order> userOrders = orderDao.readUserOrders(userId);
		if (userOrders == null) {
			return false;
		}
		for (Order order : userOrders) {
			if (order.getStatus() != OrderStatusEnum.FINISHED
					&& order.getStatus() != OrderStatusEnum.CANCELLED
					&& order.getStatus() != OrderStatusEnum.REJECTED) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> getResevedDatesList(int carId) throws ServiceException {
		List<Order> orderDatesList = orderDao.readReservedDatesForCar(carId);
		List<String> reservedDates = new ArrayList<>();
		for (Order order : orderDatesList) {
			LocalDate start = order.getStartDate();
			LocalDate end = order.getEndDate();
			while (!start.isAfter(end)) {
				reservedDates.add(start.toString());
				start = start.plusDays(1);
			}
		}
		return reservedDates;
	}

}
