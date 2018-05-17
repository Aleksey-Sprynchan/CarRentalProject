package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CancelOrderCommandImpl implements BaseCommand {

	public static final String MESSAGE_VALUE = "Order was cancelled!";

	private OrderService orderService = new OrderServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));
		orderService.updateOrderStatus(orderId, OrderStatusEnum.CANCELLED);
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_MY_ORDERS);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_USER_URL;

	}
}
