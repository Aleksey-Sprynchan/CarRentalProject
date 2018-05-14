package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.exeption.BaseException;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class ShowOrdersByStatusCommandImpl extends CommonAdminCommand implements BaseCommand {
	
	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		String selectedStatusString = request.getParameter(REQUEST_PARAM_ORDER_STATUS);
		OrderStatusEnum selectedStatus = null;
		if (REQUEST_PARAM_ALL_ORDERS.equals(selectedStatusString)) {
			setAttributetOrderList(request, null);
		} else {
			selectedStatus = OrderStatusEnum.valueOf(request.getParameter(REQUEST_PARAM_ORDER_STATUS).replace(' ', '_'));
			setAttributetOrderList(request, selectedStatus);
		}	
		setAttributetOrderStatusList(request);
		return PAGE_ADMIN_PROFILE;
	}
}
