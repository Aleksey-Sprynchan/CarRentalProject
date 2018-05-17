package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ORDER_DETAILS;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminMethods;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RedirectAdminCommandImpl extends CommonAdminMethods implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		String pageType = (String) request.getSession().getAttribute(SESSION_ATR_SESSION_PAGE_TYPE);

		switch (pageType) {
		case PAGE_TYPE_ADMIN_PROFILE:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			setAttributetOrderList(request, null);
			setAttributetOrderStatusList(request);
			return PAGE_ADMIN_PROFILE;
		case PAGE_TYPE_ORDER_DETAILS:
			int orderId = (int) request.getSession().getAttribute(SESSION_ATR_SESSION_ORDER_ID);
			Order order = orderService.getOrder(orderId);
			request.setAttribute(REQUEST_PARAM_ORDER, order);
			return PAGE_ORDER_DETAILS;
		default:
			return PAGE_INDEX;
		}
	}

}
