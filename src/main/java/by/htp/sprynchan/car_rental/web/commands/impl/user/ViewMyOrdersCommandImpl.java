package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ViewMyOrdersCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();
	private CarService carService = new CarServiceImpl();
	private static final String PARAMETER_USER = "user";
	public static final String PARAMETER_ORDER_LIST = "order_list";
	public static final String PARAMETER_ORDER_CAR_MAP = "orderCar_map";


	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		int userId = user.getId();
		List<Order> orderList = orderService.getUserOrderList(userId);
		Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);	
		request.setAttribute(PARAMETER_ORDER_LIST, orderList);
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
