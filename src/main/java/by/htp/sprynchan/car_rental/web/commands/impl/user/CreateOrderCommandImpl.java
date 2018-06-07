package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_BOOK_CAR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CreateOrderCommandImpl extends UserCommansHelper implements BaseCommand {

	private static final String MESSAGE_VALUE = "success_create_order";
	private OrderService orderService = ServiceFactory.getOrderService();
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		Map<String, String> orderParams = getRequestOrderParamsMap(request);
		Map<String, String> customerParams = getRequestCustomerParamsMap(request);
		if (validateOrderInputData(orderParams, customerParams, request)) {
			Order order = buildNewOrder(orderParams, buildCustomer(customerParams), request);
			orderService.createNewOrder(order);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_USER_URL;
		} else {
			setAttributetReservedDates(request, formatInt(orderParams.get(REQUEST_PARAM_CAR_ID)));
			request.setAttribute(REQUEST_PARAM_CAR,
					carService.getCar(formatInt(orderParams.get(REQUEST_PARAM_CAR_ID))));
			return PAGE_BOOK_CAR;
		}
	}

	private Map<String, String> getRequestOrderParamsMap(HttpServletRequest request) {
		Map<String, String> orderParams = new HashMap<>();
		orderParams.put(REQUEST_PARAM_CAR_ID, request.getParameter(REQUEST_PARAM_CAR_ID));
		orderParams.put(REQUEST_PARAM_START_DATE, request.getParameter(REQUEST_PARAM_START_DATE));
		orderParams.put(REQUEST_PARAM_END_DATE, request.getParameter(REQUEST_PARAM_END_DATE));
		orderParams.put(REQUEST_PARAM_TOTAL_PRICE, request.getParameter(REQUEST_PARAM_TOTAL_PRICE));
		return orderParams;
	}

	private Order buildNewOrder(Map<String, String> orderParams, CustomerPersonalData customer,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		Order order = new Order();
		order.setStatus(OrderStatusEnum.WAITING_FOR_APPROVE);
		order.setOrderDate(LocalDate.now());
		order.setUserId(user.getId());
		order.setCarId(formatInt(orderParams.get(REQUEST_PARAM_CAR_ID)));
		order.setStartDate(formatLocalDate(orderParams.get(REQUEST_PARAM_START_DATE)));
		order.setEndDate(formatLocalDate(orderParams.get(REQUEST_PARAM_END_DATE)));
		order.setCustomer(customer);
		order.setTotalPrice(formatInt(orderParams.get(REQUEST_PARAM_TOTAL_PRICE)));
		order.setInsurance(formatBoolean(request.getParameter(REQUEST_PARAM_INSURANCE)));
		return order;
	}

	private boolean validateOrderInputData(Map<String, String> orderParams, Map<String, String> customerParams,
			HttpServletRequest request) throws ValidateNullRequestParamException {

		boolean result = true;
		if (!validatePositiveInt(orderParams.get(REQUEST_PARAM_CAR_ID))) {
			result = false;
		}
		if (!validateDate(orderParams.get(REQUEST_PARAM_START_DATE))) {
			request.setAttribute(REQUEST_PARAM_INVALID_START_DATE,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_DATE, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_START_DATE, orderParams.get(REQUEST_PARAM_START_DATE));
		}
		if (!validateDate(orderParams.get(REQUEST_PARAM_END_DATE))) {
			request.setAttribute(REQUEST_PARAM_INVALID_END_DATE,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_DATE, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_END_DATE, orderParams.get(REQUEST_PARAM_END_DATE));
		}
		if (!validatePositiveInt(orderParams.get(REQUEST_PARAM_TOTAL_PRICE))) {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_TOTAL_PRICE, request));
			result = false;
		}
		if (!validateCustomerInputData(customerParams, request)) {
			result = false;
		}
		return result;
	}

}
