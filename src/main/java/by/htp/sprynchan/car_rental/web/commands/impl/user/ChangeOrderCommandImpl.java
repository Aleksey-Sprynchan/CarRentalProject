package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_MY_ORDERS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangeOrderCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_VALUE = "Information was succsefully updated!";
	
	private OrderService orderService = new OrderServiceImpl();
	private CustomerPersonalDataService customerService = new CustomerPersonalDataServiceImpl();
	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int customerId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CUSTOMER_ID));
		String customerName = request.getParameter(REQUEST_PARAM_CUSTOMER_NAME);
		String customerSurname = request.getParameter(REQUEST_PARAM_CUSTOMER_SURNAME);
		String passportNumb  = request.getParameter(REQUEST_PARAM_PASSPORT_NUMB);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(REQUEST_PARAM_DATE_OF_BIRTH));
		int drivingExp = Integer.parseInt(request.getParameter(REQUEST_PARAM_DRIVING_EXP));
		
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setId(customerId);
		customer.setName(customerName);
		customer.setSurname(customerSurname);
		customer.setPassportNumb(passportNumb);
		customer.setDateOfBirth(dateOfBirth);
		customer.setDrivingExp(drivingExp);
		customerService.changeCustomerInfo(customer);

		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		List<Order> orderList= orderService.getUserOrderList(user.getId());
		request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);
		Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);	
		request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
		return PAGE_MY_ORDERS;
	}
	
	private Map<Integer, Car> getCarsForOrderList(List<Order> orderList) throws ServiceException {
		Map<Integer, Car> orderCarMap = new HashMap<Integer, Car>();
		for (Order order : orderList) {
			int carId = order.getCarId();
			Car car = carService.getCar(carId);
			orderCarMap.put(order.getId(), car);
		}
		return orderCarMap;
	}

}
