package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_EDIT_CAR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class EditCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();	

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		Car car = carService.getCar(carId);
		request.setAttribute(REQUEST_PARAM_CAR, car);	
		Set<String> brandNames = carService.getBrandList();
		request.setAttribute(REQUEST_PARAM_BRAND_NAMES_LIST, brandNames);
		return PAGE_EDIT_CAR;		
	}
}
