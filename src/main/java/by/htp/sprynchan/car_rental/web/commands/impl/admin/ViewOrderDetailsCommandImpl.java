package by.htp.sprynchan.car_rental.web.commands.impl.admin;


import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ORDER_DETAILS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ViewOrderDetailsCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();
	private CustomerPersonalDataService customerService  = new CustomerPersonalDataServiceImpl();
	
	public static final String PARAMETER_USER = "user";
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_ORDER = "order";
	
	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		Order order = orderService.getOrder(orderId);
		CustomerPersonalData customer = customerService.getCustomerPersonalData(order.getCustomer().getId());
		order.setCustomer(customer);
		request.setAttribute(PARAMETER_ORDER, order);
		
		User currentUser = userService.getUser(order.getUserId());
		request.setAttribute(PARAMETER_USER, currentUser);
		
		return PAGE_ORDER_DETAILS;
	}

}
