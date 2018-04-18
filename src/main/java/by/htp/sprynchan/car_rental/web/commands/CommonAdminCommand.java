package by.htp.sprynchan.car_rental.web.commands;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public abstract class CommonAdminCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	private static final String PARAMETER_ORDER_LIST = "order_list";
	private static final String PARAMETER_ORDER_STATUS_LIST = "order_status_list";

	public CommonAdminCommand() {}
	
	protected void setAttributetOrderList (HttpServletRequest request, OrderStatusEnum status) {	
		List<Order> orderList= orderService.getOrderList(status);
		request.setAttribute(PARAMETER_ORDER_LIST, orderList);
	}
	
	protected void setAttributetOrderStatusList(HttpServletRequest request) {
		List<String> orderStatusList = new ArrayList<String>();
		for(OrderStatusEnum e: OrderStatusEnum.values()) {
			orderStatusList.add(e.toString().replace('_', ' '));						
		}		
		request.setAttribute(PARAMETER_ORDER_STATUS_LIST, orderStatusList);	
	}
	

	
	
	

}
