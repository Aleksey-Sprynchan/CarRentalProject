package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ORDER_DETAILS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewOrderDetailsCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private UserService userService = new UserServiceImpl();
	private CustomerPersonalDataService customerService  = new CustomerPersonalDataServiceImpl();
	private DamageService damageService = new DamageServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));		
		Order order = orderService.getOrder(orderId);
		CustomerPersonalData customer = customerService.getCustomerPersonalData(order.getCustomer().getId());
		order.setCustomer(customer);
		request.setAttribute(REQUEST_PARAM_ORDER, order);
		
		List<Damage> orderDamages = damageService.getOrderDamages(orderId);
		request.setAttribute(REQUEST_PARAM_ORDER_DAMAGES, orderDamages);
		
		User currentUser = userService.getUser(order.getUserId());
		request.setAttribute(REQUEST_PARAM_USER, currentUser);	
		return PAGE_ORDER_DETAILS;
	}

}
