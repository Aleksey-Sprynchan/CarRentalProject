package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CREATE_CAR;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class AddingCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();
	
	private static final String PARAMETER_BRAND_NAMES = "brand_names";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
			
		Set<String> brandNames = carService.getBrandList();
		request.setAttribute(PARAMETER_BRAND_NAMES, brandNames);
		return PAGE_CREATE_CAR;

	}

}
