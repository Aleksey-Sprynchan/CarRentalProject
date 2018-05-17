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

public class PayForDamageCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	private static final String MESSAGE_SUCCESSFUL_PAYMENT = "Successful damage payment. Order is finished!";
	private static final String MESSAGE_NO_MONEY = "Insufficient funds in the account! Please, make a deposit!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = formatInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		Order order = orderService.getOrder(orderId);
		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		if(user.getBalance() >= order.getDamageAmount()) {		
			user.setBalance(user.getBalance() - order.getDamageAmount());
			userService.changeUserBalance(user);		
			orderService.updateOrderStatus(orderId, OrderStatusEnum.FINISHED);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_SUCCESSFUL_PAYMENT);
		} else {
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_NO_MONEY);
		}
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_MY_ORDERS);
		return REDIRECT_USER_URL;
	}

}
