package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_MANAGE_ORDER;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ManageOrderCommandImpl implements BaseCommand {

	private OrderService orderService = ServiceFactory.getOrderService();
	private UserService userService = ServiceFactory.getUserService();
	private CustomerPersonalDataService customerService  = ServiceFactory.getCarCustomerPersonalDataService();
	private DamageService damageService = ServiceFactory.getDamageService();
	private CarService carService = ServiceFactory.getCarService();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
		Order order = orderService.getOrder(formatInt(orderId));
		CustomerPersonalData customer = customerService.getCustomerPersonalData(order.getCustomer().getId());
		order.setCustomer(customer);
		request.setAttribute(REQUEST_PARAM_ORDER, order);
		request.setAttribute(REQUEST_PARAM_CAR, carService.getCar(order.getCarId()));	
		request.setAttribute(REQUEST_PARAM_ORDER_DAMAGES, damageService.getOrderDamages(formatInt(orderId)));		
		request.setAttribute(REQUEST_PARAM_CURRENT_USER, userService.getUser(order.getUserId()));	
		return PAGE_MANAGE_ORDER;
		} else {
			return PAGE_ERROR;
		}
	}

}
