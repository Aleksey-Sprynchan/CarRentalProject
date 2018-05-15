package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CreateOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private CarService carService = new CarServiceImpl();
	
	private static final String MESSAGE_VALUE = "You successfully create new order! "
			+ "Watch your orders at MY ORDERS section";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
				
		OrderStatusEnum orderStatus = OrderStatusEnum.WAITING_FOR_APPROVE;
		LocalDate orderDate = LocalDate.now();
		String customerName = request.getParameter(REQUEST_PARAM_CUSTOMER_NAME);
		String customerSurname = request.getParameter(REQUEST_PARAM_CUSTOMER_SURNAME);
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		String passportNumb  = request.getParameter(REQUEST_PARAM_PASSPORT_NUMB);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(REQUEST_PARAM_DATE_OF_BIRTH));	
		int drivingExp = Integer.parseInt(request.getParameter(REQUEST_PARAM_DRIVING_EXP));
		int bookingCarId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		LocalDate startDate = LocalDate.parse(request.getParameter(REQUEST_PARAM_START_DATE));
		LocalDate endDate = LocalDate.parse(request.getParameter(REQUEST_PARAM_END_DATE));	
		int totalPrice = Integer.parseInt(request.getParameter(REQUEST_PARAM_TOTAL_PRICE));		
		boolean isInsurance = Boolean.parseBoolean(request.getParameter(REQUEST_PARAM_INSURANCE)); 
		
		Order order = new Order();
		order.setStatus(orderStatus);
		order.setOrderDate(orderDate);
		order.setUserId(user.getId());
		order.setCarId(bookingCarId);
		order.setStartDate(startDate);
		order.setEndDate(endDate);
		order.setCustomer(new CustomerPersonalData(customerName, customerSurname, passportNumb, dateOfBirth, drivingExp));
		order.setTotalPrice(totalPrice);
		order.setInsurance(isInsurance);
				
		orderService.createNewOrder(order);	
		
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);					
		return PAGE_USER_PROFILE;		
	}

}
