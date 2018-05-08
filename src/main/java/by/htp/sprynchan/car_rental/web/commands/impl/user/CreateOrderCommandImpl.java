package by.htp.sprynchan.car_rental.web.commands.impl.user;


import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CreateOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private CarService carService = new CarServiceImpl();
	private CustomerPersonalDataService customerPersonalDataService = new CustomerPersonalDataServiceImpl();
	
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_CUSTOMER_NAME = "customer_name";
	private static final String PARAMETER_CUSTOMER_SURNAME = "customer_surname";
	private static final String PARAMETER_PASSPORT_NUMB = "passport_numb";
	private static final String PARAMETER_DATE_OF_BIRTH = "date_of_birth";
	private static final String PARAMETER_DRIVING_EXP = "driving_exp";
	private static final String PARAMETER_CAR_ID = "car_id";
	private static final String PARAMETER_START_DATE = "start_date";
	private static final String PARAMETER_END_DATE = "end_date";
	private static final String PARAMETER_TOTAL_PRICE = "total_price";
	private static final String PARAMETER_INSURANCE = "insurance";
	private static final String COMMAND = "command";
	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
				
		OrderStatusEnum orderStatus = OrderStatusEnum.WAITING_FOR_APPROVE;
		LocalDate orderDate = LocalDate.now();
		String customerName = request.getParameter(PARAMETER_CUSTOMER_NAME);
		String customerSurname = request.getParameter(PARAMETER_CUSTOMER_SURNAME);
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		int userId  = user.getId();
		String passportNumb  = request.getParameter(PARAMETER_PASSPORT_NUMB);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(PARAMETER_DATE_OF_BIRTH));	
		int drivingExp = Integer.parseInt(request.getParameter(PARAMETER_DRIVING_EXP));
		int bookingCarId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		LocalDate startDate = LocalDate.parse(request.getParameter(PARAMETER_START_DATE));
		LocalDate endDate = LocalDate.parse(request.getParameter(PARAMETER_END_DATE));	
		int totalPrice = Integer.parseInt(request.getParameter(PARAMETER_TOTAL_PRICE));		
		boolean isInsurance = Boolean.parseBoolean(request.getParameter(PARAMETER_INSURANCE)); 
		
		Order order = new Order();
		order.setStatus(orderStatus);
		order.setOrderDate(orderDate);
		order.setUserId(userId);
		order.setCarId(bookingCarId);
		order.setStartDate(startDate);
		order.setEndDate(endDate);
		order.setCustomer(new CustomerPersonalData(customerName, customerSurname, passportNumb, dateOfBirth, drivingExp));
		order.setTotalPrice(totalPrice);
		order.setInsurance(isInsurance);
		
			
		int id = orderService.createNewOrder(order);
		
//		carService.updateIsAvailableStatus(bookingCarId, request.getParameter(COMMAND));
					
		request.setAttribute("this_order", orderService.getOrder(id));
		request.setAttribute("cpData", customerPersonalDataService.getCustomerPersonalData(orderService.getOrder(id).getCustomer().getId()));
		request.setAttribute("booking_car", carService.getCar(bookingCarId));
							
		return PAGE_SUBMIT_STEP;
		
	}

}
