package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;

public class SendRejectMessageCommandImpl extends CommonAdminCommand implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	
	public static final String PARAMETER_ORDER_ID = "order_id";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String PARAMETER_REJECTION_REASON = "rejection_reason";
	private static final String MESSAGE_VALUE = "Order has been rejected!";
	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		String rejectionReason = request.getParameter(PARAMETER_REJECTION_REASON);
		orderService.rejectOrder(orderId, rejectionReason);
		
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE_VALUE);
		return PAGE_ADMIN_PROFILE;
	}

}