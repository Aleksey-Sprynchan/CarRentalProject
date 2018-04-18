package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class EditCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();	
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String PARAMETER_CAR_TO_EDIT = "carToEdit";
	private static final String PARAMETER_BRAND_NAMES = "brand_names";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		Car carToEdit = carService.getCar(carId);
		request.setAttribute(PARAMETER_CAR_TO_EDIT, carToEdit);
		
		Set<String> brandList = carService.getBrandList();
		request.setAttribute(PARAMETER_BRAND_NAMES, brandList);
		return PAGE_EDIT_CAR;
		
	}

}
