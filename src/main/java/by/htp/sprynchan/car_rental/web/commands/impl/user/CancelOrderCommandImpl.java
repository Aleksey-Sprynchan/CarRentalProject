package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CancelOrderCommandImpl implements BaseCommand {

	public static final String MESSAGE_VALUE = "success_cancel_order";
	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
			orderService.updateOrderStatus(formatInt(orderId), OrderStatusEnum.CANCELLED);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_USER_URL;
		} else {
			return PAGE_ERROR;
		}
	}
}
