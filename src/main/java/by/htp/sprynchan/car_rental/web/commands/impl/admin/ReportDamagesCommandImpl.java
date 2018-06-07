package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REPORT_DAMAGES;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ReportDamagesCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (validatePositiveInt(orderId) && validatePositiveInt(carId)) {
			request.setAttribute(REQUEST_PARAM_ORDER_ID, orderId);
			request.setAttribute(REQUEST_PARAM_CAR_ID, carId);
			return PAGE_REPORT_DAMAGES;
		} else {
			return PAGE_ERROR;
		}
	}

}
