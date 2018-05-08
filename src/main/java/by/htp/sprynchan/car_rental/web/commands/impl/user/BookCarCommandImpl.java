package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import org.json.simple.JSONArray;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class BookCarCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String PARAMETER_CAR = "car";
	private static final String PARAMETER_RESERVED_DATES = "reserved_dates";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
					
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));	
		List<String> reservedDates = orderService.getResevedDatesList(carId);
	
		@SuppressWarnings("unchecked")
		List<String> reservedDatesJSON = new JSONArray();
		for(String s: reservedDates) {
			reservedDatesJSON.add(s);
		}

		request.setAttribute(PARAMETER_RESERVED_DATES, reservedDatesJSON);
		Car bookingCar = carService.getCar(carId);	
		request.setAttribute(PARAMETER_CAR, bookingCar);	
		return PAGE_BOOK_CAR;

	}

}
