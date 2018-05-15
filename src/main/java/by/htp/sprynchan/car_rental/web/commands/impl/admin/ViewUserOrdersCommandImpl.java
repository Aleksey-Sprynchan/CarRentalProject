package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewUserOrdersCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		int userId = Integer.parseInt(request.getParameter(REQUEST_PARAM_USER_ID));		
		List<Order> orderList = orderService.getUserOrderList(userId);
		request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);	
		return PAGE_USER_ORDERS;
	}

}
