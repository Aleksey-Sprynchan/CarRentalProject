package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class PayForOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_ORDER_LIST = "order_list";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE_VALUE = "Order was successfully paid";
	private static final String PARAMETER_USER = "user";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		orderService.updateOrderStatus(orderId, OrderStatusEnum.PAID);
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		int userId  = user.getId();	
		List<Order> orderList= orderService.getUserOrderList(userId);
		request.setAttribute(PARAMETER_ORDER_LIST, orderList);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE_VALUE);
		return PAGE_USER_ORDERS;

	}

}
