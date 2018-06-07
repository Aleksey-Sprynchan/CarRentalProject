package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CREATE_CAR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class AddCarCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private static final String MESSAGE_VALUE = "success_add_car";
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		Map<String, String> requestParams = getRequestCarParamsMap(request);
		if (validateCarInputData(requestParams, request)) {
			Car car = buildCar(requestParams);
			carService.addCarToCarPark(car);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_ADMIN_URL;
		} else {
			return PAGE_CREATE_CAR;
		}
	}

}
