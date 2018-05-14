package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ORDERS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	public static final String MESSAGE_VALUE = "Order was cancelled!";

	private OrderService orderService = new OrderServiceImpl();
	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {

		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));
		orderService.updateOrderStatus(orderId, OrderStatusEnum.CANCELLED);	
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);	
		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		List<Order> orderList= orderService.getUserOrderList(user.getId());
		request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_VALUE);
		Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);	
		request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
		return PAGE_USER_ORDERS;
		
	}
	
	private Map<Integer, Car> getCarsForOrderList(List<Order> orderList) {
		Map<Integer, Car> orderCarMap = new HashMap<Integer, Car>();
		for (Order order : orderList) {
			int carId = order.getCarId();
			Car car = carService.getCar(carId);
			orderCarMap.put(order.getId(), car);
		}
		return orderCarMap;
	}

}
