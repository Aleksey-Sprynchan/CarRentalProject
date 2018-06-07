package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class ShowOrdersByStatusCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private OrderService orderService = ServiceFactory.getOrderService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String selectedStatusString = request.getParameter(REQUEST_PARAM_ORDER_STATUS);
		if (selectedStatusString == null) {
			selectedStatusString = REQUEST_PARAM_ALL_ORDERS;
		}
		if (REQUEST_PARAM_ALL_ORDERS.equals(selectedStatusString)) {
			setAttributetOrderListAndOrderCarMap(request);
			setAttributetOrderUserMap(request);
		} else {
			setSelectedStatusValues(selectedStatusString, request);
		}
		setAttributetOrderStatusList(request);
		request.setAttribute(REQUEST_PARAM_SELECTED_STATUS, selectedStatusString);
		return PAGE_ADMIN_PROFILE;
	}

	private void setSelectedStatusValues(String selectedStatusString, HttpServletRequest request)
			throws ServiceException {
		try {
			OrderStatusEnum selectedStatus = OrderStatusEnum
					.valueOf(selectedStatusString.replace(' ', '_').toUpperCase());
			List<Order> orderList = orderService.getOrderListByStatus(selectedStatus);
			request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
			request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, getCarsForOrderList(orderList));
			request.setAttribute(REQUEST_PARAM_ORDER_USER_MAP, getUsersForOrderList(orderList));
		} catch (IllegalArgumentException e) {
			setAttributetOrderListAndOrderCarMap(request);
			setAttributetOrderUserMap(request);
		}
	}
}
