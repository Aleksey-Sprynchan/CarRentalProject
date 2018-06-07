package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REJECTION_FORM;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RejectOrderCommandImpl implements BaseCommand {
	
	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {	
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
			Order order = orderService.getOrder(formatInt(orderId));
			request.setAttribute(REQUEST_PARAM_ORDER, order);
			return PAGE_REJECTION_FORM;
		} else {
			return PAGE_ERROR;
		}
	}

}
