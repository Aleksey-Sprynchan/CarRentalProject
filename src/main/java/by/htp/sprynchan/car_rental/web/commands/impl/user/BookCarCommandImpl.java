package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_BOOK_CAR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class BookCarCommandImpl extends UserCommansHelper implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (validatePositiveInt(carId)) {
			setAttributetReservedDates(request, formatInt(carId));
			setAttributetCurrentCar(request, formatInt(carId));
			return PAGE_BOOK_CAR;
		} else {
			return PAGE_ERROR;
		}
	}

}
