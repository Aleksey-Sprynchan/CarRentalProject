package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class MarkAsReturnedCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		orderService.updateOrderStatus(orderId, OrderStatusEnum.RETURNED);		
		request.getSession().setAttribute(SESSION_ATR_SESSION_ORDER_ID, orderId); 
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ORDER_DETAILS);
		return REDIRECT_ADMIN_URL;
	}
}
