package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;


public class BookCarCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();
	
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String PARAMETER_CAR = "car";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
					
		int id = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		Car bookingCar = carService.getCar(id);	
		request.setAttribute(PARAMETER_CAR, bookingCar);
		
		return PAGE_BOOK_CAR;

	}

}
