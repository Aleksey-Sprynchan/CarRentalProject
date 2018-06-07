package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CAR_PARK;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewCarParkCommandImpl implements BaseCommand {

	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carService.getAvailableCarPark());
		request.setAttribute(REQUEST_PARAM_INACTIVE_CARS, carService.getInactiveCarPark());
		return PAGE_CAR_PARK;
	}
}
