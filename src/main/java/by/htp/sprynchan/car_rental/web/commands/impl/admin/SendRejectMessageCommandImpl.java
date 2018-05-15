package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class SendRejectMessageCommandImpl extends CommonAdminCommand implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	
	private static final String MESSAGE_VALUE = "Order has been rejected!";
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		String rejectionReason = request.getParameter(REQUEST_PARAM_REJECTION_REASON);
		orderService.rejectOrder(orderId, rejectionReason);
		
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);
		return PAGE_ADMIN_PROFILE;
	}

}
