package by.htp.sprynchan.car_rental.web.commands.impl.admin.util;

import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public abstract class AdminCommandsHelper {
	
	private OrderService orderService = ServiceFactory.getOrderService();
	private CarService carService = ServiceFactory.getCarService();
	private UserService userService = ServiceFactory.getUserService();
	
	protected void setAttributetOrderListAndOrderCarMap(HttpServletRequest request) throws ServiceException {
		List<Order> orderList = orderService.getOrderList();
		request.setAttribute(REQUEST_PARAM_ORDER_LIST, orderList);
		Map<Integer, Car> orderCarMap = getCarsForOrderList(orderList);
		request.setAttribute(REQUEST_PARAM_ORDER_CAR_MAP, orderCarMap);
	}
	
	protected Map<Integer, Car> getCarsForOrderList(List<Order> orderList) throws ServiceException {
		Map<Integer, Car> orderCarMap = new HashMap<Integer, Car>();
		for (Order order : orderList) {
			int carId = order.getCarId();
			Car car = carService.getCar(carId);
			orderCarMap.put(order.getId(), car);
		}
		return orderCarMap;
	}
	
	protected void setAttributetOrderUserMap (HttpServletRequest request) throws ServiceException {
		List<Order> orderList = orderService.getOrderList();
		Map<Integer, User> orderUserMap = getUsersForOrderList(orderList);
		request.setAttribute(REQUEST_PARAM_ORDER_USER_MAP, orderUserMap);
	}
	
	protected Map<Integer, User> getUsersForOrderList(List<Order> orderList) throws ServiceException {
		Map<Integer, User> orderUserMap = new HashMap<Integer, User>();
		for (Order order : orderList) {
			int userId = order.getUserId();
			User user = userService.getUser(userId);
			orderUserMap.put(order.getId(), user);
		}	
		return orderUserMap;
	}

	protected void setAttributetOrderStatusList(HttpServletRequest request) {
		List<String> orderStatusList = new ArrayList<>();
		for (OrderStatusEnum e : OrderStatusEnum.values()) {
			orderStatusList.add(e.toString().replace('_', ' ').toLowerCase());
		}
		request.setAttribute(REQUEST_PARAM_ORDER_STATUS_LIST, orderStatusList);
	}
	
	protected Map<String, String> getRequestCarParamsMap(HttpServletRequest request) {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put(REQUEST_PARAM_BRAND_NAME, request.getParameter(REQUEST_PARAM_BRAND_NAME));
		requestParams.put(REQUEST_PARAM_MODEL, request.getParameter(REQUEST_PARAM_MODEL));
		requestParams.put(REQUEST_PARAM_TYPE, request.getParameter(REQUEST_PARAM_TYPE));
		requestParams.put(REQUEST_PARAM_TRANSMISSION, request.getParameter(REQUEST_PARAM_TRANSMISSION));
		requestParams.put(REQUEST_PARAM_PASSENGERS, request.getParameter(REQUEST_PARAM_PASSENGERS));
		requestParams.put(REQUEST_PARAM_FUEL, request.getParameter(REQUEST_PARAM_FUEL));
		requestParams.put(REQUEST_PARAM_AIR_CONDITION, request.getParameter(REQUEST_PARAM_AIR_CONDITION));
		requestParams.put(REQUEST_PARAM_PRICE_PER_DAY, request.getParameter(REQUEST_PARAM_PRICE_PER_DAY));
		requestParams.put(REQUEST_PARAM_IMAGE, request.getParameter(REQUEST_PARAM_IMAGE));
		return requestParams;
	}
	
	protected Car buildCar(Map<String, String> requestParams) {
		Car car = new Car();
		car.setBrandName(requestParams.get(REQUEST_PARAM_BRAND_NAME));
		car.setModel(requestParams.get(REQUEST_PARAM_MODEL));
		car.setType(requestParams.get(REQUEST_PARAM_TYPE));
		car.setTransmission(requestParams.get(REQUEST_PARAM_TRANSMISSION));
		car.setPassengers(formatInt(requestParams.get(REQUEST_PARAM_PASSENGERS)));
		car.setFuel(requestParams.get(REQUEST_PARAM_FUEL));
		car.setAirCondition(formatBoolean(requestParams.get(REQUEST_PARAM_AIR_CONDITION)));
		car.setPricePerDay(formatInt(requestParams.get(REQUEST_PARAM_PRICE_PER_DAY)));
		car.setAvailable(true);
		car.setImage(requestParams.get(REQUEST_PARAM_IMAGE));
		return car;
	}
	
	protected boolean validateCarInputData(Map<String, String> requestParams, HttpServletRequest request)
			throws ValidateNullRequestParamException {

		boolean result = true;
		if (!validateBrandNameOrModel(requestParams.get(REQUEST_PARAM_BRAND_NAME))) {
			request.setAttribute(REQUEST_PARAM_INVALID_BRAND, Resource.getStrLocale(REQUEST_PARAM_INVALID_BRAND, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_BRAND_NAME, requestParams.get(REQUEST_PARAM_BRAND_NAME));
		}
		if (!validateBrandNameOrModel(requestParams.get(REQUEST_PARAM_MODEL))) {
			request.setAttribute(REQUEST_PARAM_INVALID_MODEL, Resource.getStrLocale(REQUEST_PARAM_INVALID_MODEL, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_MODEL, requestParams.get(REQUEST_PARAM_MODEL));
		}
		if (!validateType(requestParams.get(REQUEST_PARAM_TYPE))) {
			request.setAttribute(REQUEST_PARAM_INVALID_TYPE, Resource.getStrLocale(REQUEST_PARAM_INVALID_TYPE, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_TYPE, requestParams.get(REQUEST_PARAM_TYPE));
		}
		if (!validateTransmission(requestParams.get(REQUEST_PARAM_TRANSMISSION))) {
			request.setAttribute(REQUEST_PARAM_INVALID_TRANSMISSION, Resource.getStrLocale(REQUEST_PARAM_INVALID_TRANSMISSION, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_TRANSMISSION, requestParams.get(REQUEST_PARAM_TRANSMISSION));
		}
		if (!validatePassengers(requestParams.get(REQUEST_PARAM_PASSENGERS))) {
			request.setAttribute(REQUEST_PARAM_INVALID_PASSENGERS, Resource.getStrLocale(REQUEST_PARAM_INVALID_PASSENGERS, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_PASSENGERS, requestParams.get(REQUEST_PARAM_PASSENGERS));
		}
		if (!validateFuel(requestParams.get(REQUEST_PARAM_FUEL))) {
			request.setAttribute(REQUEST_PARAM_INVALID_FUEL, Resource.getStrLocale(REQUEST_PARAM_INVALID_FUEL, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_FUEL, requestParams.get(REQUEST_PARAM_FUEL));
		}
		if (!validatePricePerDay(requestParams.get(REQUEST_PARAM_PRICE_PER_DAY))) {
			request.setAttribute(REQUEST_PARAM_INVALID_PRICE, Resource.getStrLocale(REQUEST_PARAM_INVALID_PRICE, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_PRICE_PER_DAY, requestParams.get(REQUEST_PARAM_PRICE_PER_DAY));
		}
		if (!validateImageLink(requestParams.get(REQUEST_PARAM_IMAGE))) {
			request.setAttribute(REQUEST_PARAM_INVALID_IMAGE_LINK, Resource.getStrLocale(REQUEST_PARAM_INVALID_IMAGE_LINK, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_IMAGE, requestParams.get(REQUEST_PARAM_IMAGE));
		}
		return result;
	}

}
