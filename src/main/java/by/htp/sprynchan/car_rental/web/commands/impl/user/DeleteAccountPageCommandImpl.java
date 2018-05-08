package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_DELETE_ACCOUNT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class DeleteAccountPageCommandImpl implements BaseCommand {
	
	
	private OrderService orderService = new OrderServiceImpl();
	
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String PARAMETER_MESSAGE_UNFINISHED_ORDERS = "You can't delete your account now! Make all payments or return a Car!!";

	public DeleteAccountPageCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		if (orderService.checkForUnfinishedOrders(user.getId())) {
			request.setAttribute(PARAMETER_MESSAGE, PARAMETER_MESSAGE_UNFINISHED_ORDERS);
		}		
		return PAGE_DELETE_ACCOUNT;
	}

}
