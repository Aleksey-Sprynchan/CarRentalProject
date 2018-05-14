package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ORDER;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangingOrderPageCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private CustomerPersonalDataService customerService = new CustomerPersonalDataServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));
		Order order = orderService.getOrder(orderId);
		order.setCustomer(customerService.getCustomerPersonalData(order.getCustomer().getId()));
		request.setAttribute(REQUEST_PARAM_ORDER, order);	
		return PAGE_CHANGE_ORDER;
	}
}
