package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_BOOK_CAR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import org.json.simple.JSONArray;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class BookCarCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();
	private OrderService orderService = new OrderServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
					
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));	
		List<String> reservedDates = orderService.getResevedDatesList(carId);
	
		@SuppressWarnings("unchecked")
		List<String> reservedDatesJSON = new JSONArray();
		for(String s: reservedDates) {
			reservedDatesJSON.add(s);
		}
		request.setAttribute(REQUEST_PARAM_RESERVED_DATES, reservedDatesJSON);
		Car bookingCar = carService.getCar(carId);	
		request.setAttribute(REQUEST_PARAM_CAR, bookingCar);	
		return PAGE_BOOK_CAR;
	}

	
}
