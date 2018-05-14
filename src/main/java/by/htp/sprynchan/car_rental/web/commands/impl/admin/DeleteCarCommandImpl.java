package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;

public class DeleteCarCommandImpl extends CommonAdminCommand implements BaseCommand {

	private CarService carService = new CarServiceImpl();
		
	private static final String MESSAGE_VALUE = "Car was succsefully deleted from car park!";
	
	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		carService.deleteCarFromCarPark(carId);
		
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		return PAGE_ADMIN_PROFILE;
	}

}
