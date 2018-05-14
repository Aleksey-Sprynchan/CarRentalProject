package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ORDER_DETAILS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class MarkAsReturnedCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		orderService.updateOrderStatus(orderId, OrderStatusEnum.RETURNED);	
		Order order = orderService.getOrder(orderId);
		request.setAttribute(REQUEST_PARAM_ORDER, order);		
		return PAGE_ORDER_DETAILS;
	}
}
