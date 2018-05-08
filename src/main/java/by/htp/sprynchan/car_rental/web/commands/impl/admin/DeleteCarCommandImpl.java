package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;

import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;

public class DeleteCarCommandImpl extends CommonAdminCommand implements BaseCommand {

	private CarService carService = new CarServiceImpl();
	
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE = "Car was succsefully deleted from car park!";
	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		carService.deleteCarFromCarPark(carId);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		return PAGE_ADMIN_PROFILE;
	}

}
