package by.htp.sprynchan.car_rental.web.commands;

import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public abstract class CommonAdminMethods {

	private OrderService orderService = new OrderServiceImpl();

	protected void setAttributetOrderList(HttpServletRequest request, OrderStatusEnum status) throws ServiceException {
		List<Order> orderList = orderService.getOrderList(status);
		request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
	}

	protected void setAttributetOrderStatusList(HttpServletRequest request) {
		List<String> orderStatusList = new ArrayList<>();
		for (OrderStatusEnum e : OrderStatusEnum.values()) {
			orderStatusList.add(e.toString().replace('_', ' '));
		}
		request.setAttribute(REQUEST_PARAM_ORDER_STATUS_LIST, orderStatusList);
	}

}
