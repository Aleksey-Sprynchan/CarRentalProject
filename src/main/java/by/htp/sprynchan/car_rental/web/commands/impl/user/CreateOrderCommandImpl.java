package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;

import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class CreateOrderCommandImpl implements BaseCommand {

	private OrderService orderService = new OrderServiceImpl();

	private static final String MESSAGE_VALUE = "You successfully create new order! "
			+ "Watch your orders at MY ORDERS section";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		orderService.createNewOrder(buildNewOrder(request));
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_USER_URL;
	}

	private Order buildNewOrder(HttpServletRequest request) {
		Map<String, String[]> reqParams = request.getParameterMap();
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		Order order = new Order();
		order.setStatus(OrderStatusEnum.WAITING_FOR_APPROVE);
		order.setOrderDate(LocalDate.now());
		order.setUserId(user.getId());
		order.setCarId(formatInt(getParameter(REQUEST_PARAM_CAR_ID, reqParams)));
		order.setStartDate(formatLocalDate(getParameter(REQUEST_PARAM_START_DATE, reqParams)));
		order.setEndDate(formatLocalDate(getParameter(REQUEST_PARAM_END_DATE, reqParams)));
		order.setCustomer(buildCustomer(reqParams));
		order.setTotalPrice(formatInt(getParameter(REQUEST_PARAM_TOTAL_PRICE, reqParams)));
		order.setInsurance(formatBoolean(getParameter(REQUEST_PARAM_INSURANCE, reqParams)));
		return order;
	}

	private CustomerPersonalData buildCustomer(Map<String, String[]> reqParams) {
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setName(getParameter(REQUEST_PARAM_CUSTOMER_NAME, reqParams));
		customer.setSurname(getParameter(REQUEST_PARAM_CUSTOMER_SURNAME, reqParams));
		customer.setPassportNumb(getParameter(REQUEST_PARAM_PASSPORT_NUMB, reqParams));
		customer.setDateOfBirth(formatLocalDate(getParameter(REQUEST_PARAM_DATE_OF_BIRTH, reqParams)));
		customer.setDrivingExp(formatInt(getParameter(REQUEST_PARAM_DRIVING_EXP, reqParams)));
		return customer;
	}

	private String getParameter(String param, Map<String, String[]> reqParams) {
		return reqParams.get(param)[0];
	}

}
