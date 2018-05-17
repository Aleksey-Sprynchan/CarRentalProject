package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class PayForOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();

	private static final String MESSAGE_SUCCESSFULL_PAYMENT = "Order was successfully paid";
	private static final String MESSAGE_NO_MONEY = "Insufficient funds in the account! Please, make a deposit!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = formatInt(request.getParameter(REQUEST_PARAM_ORDER_ID));	
		Order order = orderService.getOrder(orderId);		
		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		if(user.getBalance() >= order.getTotalPrice()) {		
			user.setBalance(user.getBalance() - order.getTotalPrice());
			userService.changeUserBalance(user);		
			orderService.updateOrderStatus(orderId, OrderStatusEnum.PAID);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_SUCCESSFULL_PAYMENT);
		} else {
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_NO_MONEY);
		}
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_MY_ORDERS);
		return REDIRECT_USER_URL;
	}

}
