package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;

public class AddCarCommandImpl extends CommonAdminCommand implements BaseCommand {

	private CarService carService = new CarServiceImpl();
	
	private static final String PARAMETER_BRAND_NAME = "brand_name";
	private static final String PARAMETER_MODEL = "model";
	private static final String PARAMETER_TYPE = "type";
	private static final String PARAMETER_TRANSMISSION= "transmission";
	private static final String PARAMETER_DOORS= "doors";
	private static final String PARAMETER_PASSENGERS= "passengers";
	private static final String PARAMETER_FUEL= "fuel";
	private static final String PARAMETER_AIR_CONDITION= "is_air_condition";
	
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE = "New car was succsefully added to car park!";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String brandName = request.getParameter(PARAMETER_BRAND_NAME);
		String model = request.getParameter(PARAMETER_MODEL);
		String type = request.getParameter(PARAMETER_TYPE);
		String transmission = request.getParameter(PARAMETER_TRANSMISSION);
		int doors = Integer.parseInt(request.getParameter(PARAMETER_DOORS));
		int passengers = Integer.parseInt(request.getParameter(PARAMETER_PASSENGERS));
		String fuel = request.getParameter(PARAMETER_FUEL);
		boolean isAirCondition = Boolean.parseBoolean(request.getParameter(PARAMETER_AIR_CONDITION));
		

		carService.addCarToCarPark(new Car(brandName, model, type, transmission, doors, passengers, fuel, isAirCondition, true));
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		return PAGE_ADMIN_PROFILE;
	}

}
