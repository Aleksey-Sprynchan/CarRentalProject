package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_START_PAGE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class StartPageCommandImpl implements BaseCommand {

	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		return PAGE_START_PAGE;
	}
	
}
