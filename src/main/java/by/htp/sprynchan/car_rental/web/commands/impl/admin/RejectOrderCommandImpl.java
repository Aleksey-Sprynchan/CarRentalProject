package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REJECTION_FORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class RejectOrderCommandImpl implements BaseCommand {
	
	private CarService carService = new CarServiceImpl();

	public static final String PARAMETER_ORDER_ID = "order_id";
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String COMMAND = "command";


	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		request.setAttribute(PARAMETER_ORDER_ID, orderId);	
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		carService.updateIsAvailableStatus(carId, request.getParameter(COMMAND));
		
		return PAGE_REJECTION_FORM;
	}
	
}
