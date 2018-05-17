package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CAR_PARK;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.bean.Car;

public class ViewCarParkCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {	
		
		List<Car> carList = carService.getCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		return PAGE_CAR_PARK;
	}

}
