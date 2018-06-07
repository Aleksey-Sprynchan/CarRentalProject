package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_DELETE_ACCOUNT;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteAccountPageCommandImpl implements BaseCommand {

	private static final String MESSAGE_VALUE = "message_unfinished_orders";
	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		if (orderService.checkForUnfinishedOrders(user.getId())) {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, Resource.getStrLocale(MESSAGE_VALUE, request));
		}
		return PAGE_DELETE_ACCOUNT;
	}
}
