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
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CancelOrderCommandImpl implements BaseCommand {
	
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE = "Order was cancelled!";
	public static final String PARAMETER_ORDER_ID = "order_id";
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_ORDER_LIST = "order_list";
	private static final String PARAMETER_ORDER_CAR_MAP = "orderCar_map";
	
	private OrderService orderService = new OrderServiceImpl();
	private CarService carService = new CarServiceImpl();

	public CancelOrderCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));
		orderService.updateOrderStatus(orderId, OrderStatusEnum.CANCELLED);	
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE);	
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
