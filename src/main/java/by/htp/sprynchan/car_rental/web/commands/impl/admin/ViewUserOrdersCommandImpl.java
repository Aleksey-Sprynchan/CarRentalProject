package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewUserOrdersCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private OrderService orderService = ServiceFactory.getOrderService();
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		if (validatePositiveInt(userId)) {
			List<Order> orderList = orderService.getUserOrderList(formatInt(userId));
			request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
			Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);
			request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
			User user = userService.getUser(formatInt(userId));
			request.setAttribute(REQUEST_PARAM_USER, user);
			return PAGE_USER_ORDERS;
		} else {
			return PAGE_ERROR;
		}
	}
	
	
	

}
