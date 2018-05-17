package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RedirectUserCommandImpl implements BaseCommand {

	private CarService carService = new CarServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private DamageService damageService = new DamageServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		String pageType = (String) request.getSession().getAttribute(SESSION_ATR_SESSION_PAGE_TYPE);

		switch (pageType) {
		case PAGE_TYPE_USER_PROFILE:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			List<Car> carList = carService.getAvailableCarPark();
			request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
			return PAGE_USER_PROFILE;

		case PAGE_TYPE_MY_ORDERS:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
			List<Order> orderList = orderService.getUserOrderList(user.getId());
			request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
			Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);
			Map<Integer, List<Damage>> orderDamageMap = new HashMap<Integer, List<Damage>>();
			for (Order order : orderList) {
				orderDamageMap.put(order.getId(), damageService.getOrderDamages(order.getId()));
			}
			request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
			request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
			request.setAttribute(REQUEST_PARAM_ORDER_DAMAGE_MAP, orderDamageMap);
			return PAGE_MY_ORDERS;

		case PAGE_TYPE_ACCOUNT_SETTINGS:
			User userXXXX = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
			request.setAttribute(REQUEST_PARAM_USER, userXXXX);
			return PAGE_USER_ACCOUNT_SETTINGS;

		case PAGE_TYPE_CHANGE_ACCOUNT_INFO:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			User user2 = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
			request.setAttribute(REQUEST_PARAM_USER, user2);
			return PAGE_CHANGE_ACCOUNT_INFO;

		case PAGE_TYPE_CHANGE_PASS:
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
			return PAGE_CHANGE_PASS;
		default:
			return PAGE_INDEX;
		}

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
