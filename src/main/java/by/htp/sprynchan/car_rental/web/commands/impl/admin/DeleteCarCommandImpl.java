package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;


import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteCarCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_VALUE = "success_delete_car";
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {	
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (validatePositiveInt(carId)) {
			carService.deleteCarFromCarPark(formatInt(carId));
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, 
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_ADMIN_URL;
		} else {
			return PAGE_ERROR;
		}
	}

}
