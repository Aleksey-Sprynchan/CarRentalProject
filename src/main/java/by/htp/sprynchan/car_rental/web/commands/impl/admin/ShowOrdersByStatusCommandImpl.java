package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.htp.sprynchan.car_rental.exeption.BaseException;


import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class ShowOrdersByStatusCommandImpl extends CommonAdminCommand implements BaseCommand {

	private static final String PARAMETER_ORDER_STATUS= "order_status";
	private static final String PARAMETER_ORDER_STATUS_ALL_ORDERS= "All orders";
	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		String selectedStatusString = request.getParameter(PARAMETER_ORDER_STATUS);
		OrderStatusEnum selectedStatus = null;
		if (PARAMETER_ORDER_STATUS_ALL_ORDERS.equals(selectedStatusString)) {
			setAttributetOrderList(request, null);
		} else {
			selectedStatus = OrderStatusEnum.valueOf(request.getParameter(PARAMETER_ORDER_STATUS).replace(' ', '_'));
			setAttributetOrderList(request, selectedStatus);
		}	
		setAttributetOrderStatusList(request);
		return PAGE_ADMIN_PROFILE;
	}

}
