package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class ApproveOrderCommandImpl extends CommonAdminCommand implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	public static final String PARAMETER_ORDER_ID = "order_id";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE_VALUE = "Order has been approved!";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		orderService.updateOrderStatus(orderId, OrderStatusEnum.WAITING_FOR_PAYMENT);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE_VALUE);
		return PAGE_ADMIN_PROFILE;
	}

}
