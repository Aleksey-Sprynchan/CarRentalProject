package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ORDER;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangingOrderPageCommandImpl implements BaseCommand {
	
	private static final String VALUE = "value";
	private static final String ERROR_WHILE_CREATING_JSON = "Error while creating json string from POJO";
	private OrderService orderService = ServiceFactory.getOrderService();
	private CustomerPersonalDataService customerService = ServiceFactory.getCarCustomerPersonalDataService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		if (validatePositiveInt(orderId)) {
			Order order = orderService.getOrder(formatInt(orderId));
			CustomerPersonalData customer = customerService.getCustomerPersonalData(order.getCustomer().getId());
			request.setAttribute(REQUEST_PARAM_CPDATA, getCustomerJSONString(customer));
			request.setAttribute(REQUEST_PARAM_DATE_OF_BIRTH, getDateOfBirthJSONString(customer));
			return PAGE_CHANGE_ORDER;
		} else {
			return PAGE_ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	private String getDateOfBirthJSONString(CustomerPersonalData customer) {
		JSONObject resultJson = new JSONObject();
		resultJson.put(VALUE, customer.getDateOfBirth().toString());
		return resultJson.toJSONString();
	}

	private String getCustomerJSONString(CustomerPersonalData customer) throws CommandException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(customer);
		} catch (JsonProcessingException e) {
			throw new CommandException(ERROR_WHILE_CREATING_JSON);
		}
	}

}
