package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class SendRejectMessageCommandImpl implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	
	private static final String MESSAGE_VALUE = "Order has been rejected!";
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		String rejectionReason = request.getParameter(REQUEST_PARAM_REJECTION_REASON);
		orderService.rejectOrder(orderId, rejectionReason);	
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_ADMIN_URL;
	}

}
