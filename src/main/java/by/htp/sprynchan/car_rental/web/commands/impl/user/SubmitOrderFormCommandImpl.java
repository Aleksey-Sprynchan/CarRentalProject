package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class SubmitOrderFormCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();
	private static final String PARAMETER_CAR_LIST = "car_list";
		
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(PARAMETER_CAR_LIST, carList);
							
		return PAGE_USER_PROFILE;
		
	}

}
