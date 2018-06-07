package by.htp.sprynchan.car_rental.web.commands.impl.user.util;

import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public abstract class UserCommansHelper {

	private CarService carService = ServiceFactory.getCarService();
	private OrderService orderService = ServiceFactory.getOrderService();

	protected void setAttributetCurrentCar(HttpServletRequest request, int carId) throws ServiceException {
		Car currentCar = carService.getCar(carId);
		request.setAttribute(REQUEST_PARAM_CAR, currentCar);
	}

	protected void setAttributetReservedDates(HttpServletRequest request, int carId) throws ServiceException {
		request.setAttribute(REQUEST_PARAM_RESERVED_DATES, getReservedDatesJSON(carId));
	}

	@SuppressWarnings("unchecked")
	protected List<String> getReservedDatesJSON(int carId) throws ServiceException {
		List<String> reservedDates = orderService.getResevedDatesList(carId);
		List<String> reservedDatesJSON = new JSONArray();
		for (String date : reservedDates) {
			reservedDatesJSON.add(date);
		}
		return reservedDatesJSON;
	}

	protected void setReqParamUser(HttpServletRequest request, String reqParam) {
		User user = (User) request.getSession().getAttribute(reqParam);
		request.setAttribute(REQUEST_PARAM_USER, user);
	}

	protected Map<String, String> getRequestCustomerParamsMap(HttpServletRequest request) {
		Map<String, String> customerParams = new HashMap<>();
		customerParams.put(REQUEST_PARAM_CUSTOMER_NAME, request.getParameter(REQUEST_PARAM_CUSTOMER_NAME));
		customerParams.put(REQUEST_PARAM_CUSTOMER_SURNAME, request.getParameter(REQUEST_PARAM_CUSTOMER_SURNAME));
		customerParams.put(REQUEST_PARAM_PASSPORT_NUMB, request.getParameter(REQUEST_PARAM_PASSPORT_NUMB));
		customerParams.put(REQUEST_PARAM_DATE_OF_BIRTH, request.getParameter(REQUEST_PARAM_DATE_OF_BIRTH));
		customerParams.put(REQUEST_PARAM_DRIVING_EXP, request.getParameter(REQUEST_PARAM_DRIVING_EXP));
		return customerParams;
	}

	protected CustomerPersonalData buildCustomer(Map<String, String> customerParams) {
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setName(customerParams.get(REQUEST_PARAM_CUSTOMER_NAME));
		customer.setSurname(customerParams.get(REQUEST_PARAM_CUSTOMER_SURNAME));
		customer.setPassportNumb(customerParams.get(REQUEST_PARAM_PASSPORT_NUMB));
		customer.setDateOfBirth(formatLocalDate(customerParams.get(REQUEST_PARAM_DATE_OF_BIRTH)));
		customer.setDrivingExp(formatInt(customerParams.get(REQUEST_PARAM_DRIVING_EXP)));
		return customer;
	}

	protected boolean validateCustomerInputData(Map<String, String> customerParams, HttpServletRequest request)
			throws ValidateNullRequestParamException {

		boolean result = true;
		if (!validateName(customerParams.get(REQUEST_PARAM_CUSTOMER_NAME))) {
			request.setAttribute(REQUEST_PARAM_INVALID_NAME,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_NAME, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_CUSTOMER_NAME, customerParams.get(REQUEST_PARAM_CUSTOMER_NAME));
		}
		if (!validateSurname(customerParams.get(REQUEST_PARAM_CUSTOMER_SURNAME))) {
			request.setAttribute(REQUEST_PARAM_INVALID_SURNAME,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_SURNAME, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_CUSTOMER_SURNAME, customerParams.get(REQUEST_PARAM_CUSTOMER_SURNAME));
		}
		if (!validatePassportNumb(customerParams.get(REQUEST_PARAM_PASSPORT_NUMB))) {
			request.setAttribute(REQUEST_PARAM_INVALID_PASSPORT_NUMB,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_PASSPORT_NUMB, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_PASSPORT_NUMB, customerParams.get(REQUEST_PARAM_PASSPORT_NUMB));
		}
		if (!validateDate(customerParams.get(REQUEST_PARAM_DATE_OF_BIRTH))) {
			request.setAttribute(REQUEST_PARAM_INVALID_BIRTH_DATE,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_DATE, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_DATE_OF_BIRTH, customerParams.get(REQUEST_PARAM_DATE_OF_BIRTH));
		}
		if (!validatePositiveInt(customerParams.get(REQUEST_PARAM_DRIVING_EXP))) {
			request.setAttribute(REQUEST_PARAM_INVALID_DRIVING_EXP,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_DRIVING_EXP, request));
			result = false;
		} else {
			request.setAttribute(REQUEST_PARAM_DRIVING_EXP, customerParams.get(REQUEST_PARAM_DRIVING_EXP));
		}
		return result;
	}

}
