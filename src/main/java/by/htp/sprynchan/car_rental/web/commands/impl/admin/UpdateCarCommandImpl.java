package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_EDIT_CAR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class UpdateCarCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private static final String MESSAGE_VALUE = "success_update_car";
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		Map<String, String> requestParams = getRequestCarParamsMap(request);
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (!validatePositiveInt(carId)) {
			return PAGE_ERROR;
		}
		if (validateCarInputData(requestParams, request)) {
			Car car = buildCar(requestParams);
			car.setId(formatInt(carId));
			carService.updateCarInfo(car);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_ADMIN_URL;
		} else {
			request.setAttribute(REQUEST_PARAM_CAR, carService.getCar(formatInt(carId)));
			Set<String> brandNames = carService.getBrandList();
			request.setAttribute(REQUEST_PARAM_BRAND_NAMES_LIST, brandNames);
			return PAGE_EDIT_CAR;
		}
	}

}
