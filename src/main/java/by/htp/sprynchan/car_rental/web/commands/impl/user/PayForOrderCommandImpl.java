package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class PayForOrderCommandImpl extends UserCommansHelper implements BaseCommand {

	private static final String MESSAGE_SUCCESSFULL_ORDER_PAYMENT = "success_order_payment";
	private static final String MESSAGE_NO_MONEY = "message_no_money";
	private OrderService orderService = ServiceFactory.getOrderService();
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
			Order order = orderService.getOrder(formatInt(orderId));
			User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
			checkBalanceAndMakePayment(user, order, request);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			return REDIRECT_USER_URL;
		} else {
			return PAGE_ERROR;
		}
	}

	private void checkBalanceAndMakePayment(User user, Order order, HttpServletRequest request)
			throws ServiceException {
		if (user.getBalance() >= order.getTotalPrice()) {
			user.setBalance(user.getBalance() - order.getTotalPrice());
			userService.changeUserBalance(user);
			orderService.updateOrderStatus(order.getId(), OrderStatusEnum.PAID);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_SUCCESSFULL_ORDER_PAYMENT, request));
		} else {
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_NO_MONEY, request));
		}
	}
}
