package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_EDIT_CAR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class EditCarCommandImpl implements BaseCommand {

	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (validatePositiveInt(carId)) {
			Car car = carService.getCar(formatInt(carId));
			request.setAttribute(REQUEST_PARAM_CAR, car);
			Set<String> brandNames = carService.getBrandList();
			request.setAttribute(REQUEST_PARAM_BRAND_NAMES_LIST, brandNames);
			return PAGE_EDIT_CAR;
		} else {
			return PAGE_ERROR;
		}
	}
}
