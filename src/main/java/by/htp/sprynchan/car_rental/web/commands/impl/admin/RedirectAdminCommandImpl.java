package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_MANAGE_ORDER;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

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
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RedirectAdminCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private OrderService orderService = ServiceFactory.getOrderService();
	private UserService userService = ServiceFactory.getUserService();
	private CustomerPersonalDataService customerService  = ServiceFactory.getCarCustomerPersonalDataService();
	private DamageService damageService = ServiceFactory.getDamageService();
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String pageType = (String) request.getSession().getAttribute(SESSION_ATR_SESSION_PAGE_TYPE);
		switch (pageType) {
		case PAGE_TYPE_ADMIN_PROFILE:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			setAttributetOrderListAndOrderCarMap(request);
			setAttributetOrderStatusList(request);
			setAttributetOrderUserMap (request);
			return PAGE_ADMIN_PROFILE;
		case PAGE_TYPE_ORDER_DETAILS:
			int orderId = (int) request.getSession().getAttribute(SESSION_ATR_SESSION_ORDER_ID);
			Order order = orderService.getOrder(orderId);
			CustomerPersonalData customer = customerService.getCustomerPersonalData(order.getCustomer().getId());
			order.setCustomer(customer);
			request.setAttribute(REQUEST_PARAM_ORDER, order);
			request.setAttribute(REQUEST_PARAM_CAR, carService.getCar(order.getCarId()));		
			request.setAttribute(REQUEST_PARAM_ORDER_DAMAGES, damageService.getOrderDamages(orderId));		
			request.setAttribute(REQUEST_PARAM_USER, userService.getUser(order.getUserId()));
			return PAGE_MANAGE_ORDER;
		default:
			return PAGE_INDEX;
		}
	}

}
