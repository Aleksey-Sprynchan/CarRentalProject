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
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RedirectUserCommandImpl extends UserCommansHelper implements BaseCommand {

	private CarService carService = ServiceFactory.getCarService();
	private OrderService orderService = ServiceFactory.getOrderService();
	private DamageService damageService = ServiceFactory.getDamageService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String pageType = (String) request.getSession().getAttribute(SESSION_ATR_SESSION_PAGE_TYPE);
		switch (pageType) {
		case PAGE_TYPE_USER_PROFILE:
			setReqParamInfoMessage(request);
			User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
			List<Order> orderList = orderService.getUserOrderList(user.getId());
			Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);
			Map<Integer, List<Damage>> orderDamageMap = getOrderDamageMap(orderList);
			request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
			request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
			request.setAttribute(REQUEST_PARAM_ORDER_DAMAGE_MAP, orderDamageMap);
			return PAGE_USER_PROFILE;
		case PAGE_TYPE_ACCOUNT_SETTINGS:
			setReqParamUser(request, REQUEST_PARAM_USER);
			return PAGE_USER_ACCOUNT_SETTINGS;
		case PAGE_TYPE_CHANGE_PERSONAL_INFO:
			setReqParamInfoMessage(request);
			setReqParamUser(request, REQUEST_PARAM_CHANGED_USER);
			return PAGE_CHANGE_PERSONAL_INFO;
		case PAGE_TYPE_CHANGE_PASS:
			setReqParamInfoMessage(request);
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

	private Map<Integer, List<Damage>> getOrderDamageMap(List<Order> orderList) throws ServiceException {
		Map<Integer, List<Damage>> orderDamageMap = new HashMap<Integer, List<Damage>>();
		for (Order order : orderList) {
			orderDamageMap.put(order.getId(), damageService.getOrderDamages(order.getId()));
		}
		return orderDamageMap;
	}

	private void setReqParamInfoMessage(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
				request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
		request.getSession().removeAttribute(SESSION_ATR_SESSION_MESSAGE);
	}

}
