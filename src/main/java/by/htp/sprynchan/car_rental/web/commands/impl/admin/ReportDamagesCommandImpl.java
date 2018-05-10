package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REPORT_DAMAGES;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ReportDamagesCommandImpl implements BaseCommand {

	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_CAR_ID = "car_id";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		request.setAttribute(PARAMETER_ORDER_ID, orderId);
		request.setAttribute(PARAMETER_CAR_ID, carId);
		
		return PAGE_REPORT_DAMAGES;
	}

}
