package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();
		
	private static final String MESSAGE_VALUE = "Car was succsefully deleted from car park!";
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
	
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		carService.deleteCarFromCarPark(carId);
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_ADMIN_URL;
	}

}
