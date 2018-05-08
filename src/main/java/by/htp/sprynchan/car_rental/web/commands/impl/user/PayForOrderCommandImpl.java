package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class PayForOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_ORDER_LIST = "order_list";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE_SUCCESSFULL_PAYMENT = "Order was successfully paid";
	private static final String MESSAGE_NO_MONEY = "Insufficient funds in the account! Please, make a deposit!";
	private static final String PARAMETER_USER = "user";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));	
		Order order = orderService.getOrder(orderId);		
		User user = (User)request.getSession().getAttribute(PARAMETER_USER);
		if(user.getBalance() >= order.getTotalPrice()) {		
			int newBalance = user.getBalance() - order.getTotalPrice();
			user.setBalance(newBalance);
			userService.changeUserBalance(user);		
			orderService.updateOrderStatus(orderId, OrderStatusEnum.PAID);
			request.setAttribute(PARAMETER_MESSAGE, MESSAGE_SUCCESSFULL_PAYMENT);
		} else {
			request.setAttribute(PARAMETER_MESSAGE, MESSAGE_NO_MONEY);
		}
		
		int userId  = user.getId();	
		List<Order> orderList= orderService.getUserOrderList(userId);
		request.setAttribute(PARAMETER_ORDER_LIST, orderList);
		
		return PAGE_USER_ORDERS;

	}

}
