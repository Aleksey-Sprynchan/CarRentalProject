package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_DELETE_ACCOUNT;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteAccountPageCommandImpl implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	
	private static final String REQUEST_PARAM_MESSAGE_UNFINISHED_ORDERS = "You can't delete your account now! "
			+ "Make all payments or return a car!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		if (orderService.checkForUnfinishedOrders(user.getId())) {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, REQUEST_PARAM_MESSAGE_UNFINISHED_ORDERS);
		}		
		return PAGE_DELETE_ACCOUNT;
	}
	
}
