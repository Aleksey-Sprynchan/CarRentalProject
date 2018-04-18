package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.bean.Car;

public class ViewCarParkCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();
	
	private static final String PARAMETER_CAR_LIST = "car_list";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) {
		
		List<Car> carList = carService.getCarPark();
		request.setAttribute(PARAMETER_CAR_LIST, carList);
		return PAGE_CAR_PARK;
	
	}

}
