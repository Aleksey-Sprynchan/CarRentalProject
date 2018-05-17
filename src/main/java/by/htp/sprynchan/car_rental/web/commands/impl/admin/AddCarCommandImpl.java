package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class AddCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();
	
	private static final String MESSAGE_VALUE = "New car was succsefully added to car park!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String brandName = request.getParameter(REQUEST_PARAM_BRAND_NAME);
		String model = request.getParameter(REQUEST_PARAM_MODEL);
		String type = request.getParameter(REQUEST_PARAM_TYPE);
		String transmission = request.getParameter(REQUEST_PARAM_TRANSMISSION);
		int passengers = Integer.parseInt(request.getParameter(REQUEST_PARAM_PASSENGERS));
		String fuel = request.getParameter(REQUEST_PARAM_FUEL);
		boolean isAirCondition = Boolean.parseBoolean(request.getParameter(REQUEST_PARAM_AIR_CONDITION));
		int pricePerDay = Integer.parseInt(request.getParameter(REQUEST_PARAM_PRICE_PER_DAY));
		String image = request.getParameter(REQUEST_PARAM_IMAGE);
		
		carService.addCarToCarPark(new Car(brandName, model, type, transmission, 
				passengers, fuel, isAirCondition, pricePerDay, true, image));
		
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_ADMIN_URL;
	}

}
