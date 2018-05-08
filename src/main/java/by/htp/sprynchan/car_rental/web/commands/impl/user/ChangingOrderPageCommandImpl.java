package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ORDER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangingOrderPageCommandImpl implements BaseCommand {
	
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_ORDER = "order";
	
	private OrderService orderService = new OrderServiceImpl();
	private CustomerPersonalDataService customerService = new CustomerPersonalDataServiceImpl();

	public ChangingOrderPageCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));
		Order order = orderService.getOrder(orderId);
		order.setCustomer(customerService.getCustomerPersonalData(order.getCustomer().getId()));
		request.setAttribute(PARAMETER_ORDER, order);	
		return PAGE_CHANGE_ORDER;
	}

}
