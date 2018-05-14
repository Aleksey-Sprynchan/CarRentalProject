package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CREATE_CAR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class CreateCarCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
			
		Set<String> brandNames = carService.getBrandList();
		request.setAttribute(REQUEST_PARAM_BRAND_NAMES_LIST, brandNames);
		return PAGE_CREATE_CAR;
	}

}
