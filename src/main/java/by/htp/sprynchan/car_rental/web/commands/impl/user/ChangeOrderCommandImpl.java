package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
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

public class ChangeOrderCommandImpl implements BaseCommand {
	
	private static final String PARAMETER_CUSTOMER_ID = "customer_id";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE = "Information was succsefully updated!";
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_ORDER_LIST = "order_list";
	private static final String PARAMETER_CUSTOMER_NAME = "customer_name";
	private static final String PARAMETER_CUSTOMER_SURNAME = "customer_surname";
	private static final String PARAMETER_PASSPORT_NUMB = "passport_numb";
	private static final String PARAMETER_DATE_OF_BIRTH = "date_of_birth";
	private static final String PARAMETER_DRIVING_EXP = "driving_exp";
	private static final String PARAMETER_ORDER_CAR_MAP = "orderCar_map";
	
	private OrderService orderService = new OrderServiceImpl();
	private CustomerPersonalDataService customerService = new CustomerPersonalDataServiceImpl();
	private CarService carService = new CarServiceImpl();

	public ChangeOrderCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int customerId = Integer.parseInt(request.getParameter(PARAMETER_CUSTOMER_ID));
		String customerName = request.getParameter(PARAMETER_CUSTOMER_NAME);
		String customerSurname = request.getParameter(PARAMETER_CUSTOMER_SURNAME);
		String passportNumb  = request.getParameter(PARAMETER_PASSPORT_NUMB);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(PARAMETER_DATE_OF_BIRTH));
		int drivingExp = Integer.parseInt(request.getParameter(PARAMETER_DRIVING_EXP));
		
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setId(customerId);
		customer.setName(customerName);
		customer.setSurname(customerSurname);
		customer.setPassportNumb(passportNumb);
		customer.setDateOfBirth(dateOfBirth);
		customer.setDrivingExp(drivingExp);
		customerService.changeCustomerInfo(customer);

		User user = (User)request.getSession().getAttribute(PARAMETER_USER);
		int userId  = user.getId();	
		List<Order> orderList= orderService.getUserOrderList(userId);
		request.setAttribute(PARAMETER_ORDER_LIST, orderList);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE);
		Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);	
		request.setAttribute(PARAMETER_ORDER_CAR_MAP, orderCarMap);
		return PAGE_USER_ORDERS;
	}
	
	Map<Integer, Car> getCarsForOrderList(List<Order> orderList) {
		Map<Integer, Car> orderCarMap = new HashMap<Integer, Car>();
		for (Order order : orderList) {
			int carId = order.getCarId();
			Car car = carService.getCar(carId);
			orderCarMap.put(order.getId(), car);
		}
		return orderCarMap;
	}

}
