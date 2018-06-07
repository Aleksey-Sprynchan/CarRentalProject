package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class MarkAsReturnedCommandImpl implements BaseCommand {

	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
			orderService.updateOrderStatus(formatInt(orderId), OrderStatusEnum.RETURNED);
			request.getSession().setAttribute(SESSION_ATR_SESSION_ORDER_ID, formatInt(orderId));
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ORDER_DETAILS);
			return REDIRECT_ADMIN_URL;
		} else {
			return PAGE_ERROR;
		}
	}
}
