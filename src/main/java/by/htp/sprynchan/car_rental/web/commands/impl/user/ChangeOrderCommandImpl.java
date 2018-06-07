package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ORDER;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangeOrderCommandImpl extends UserCommansHelper implements BaseCommand {

	private static final String MESSAGE_VALUE = "success_change_order";
	private static final String VALUE = "value";
	private CustomerPersonalDataService customerService = ServiceFactory.getCarCustomerPersonalDataService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		Map<String, String> customerParams = getRequestCustomerParamsMap(request);
		String customerId = request.getParameter(REQUEST_PARAM_CUSTOMER_ID);
		customerParams.put(REQUEST_PARAM_CUSTOMER_ID, customerId);
		if (!validatePositiveInt(customerId)) {
			return PAGE_ERROR;
		} else if (validateCustomerInputData(customerParams, request)) {
			CustomerPersonalData customer = buildCustomer(customerParams);
			customer.setId(formatInt(customerId));
			customerService.changeCustomerInfo(customer);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_USER_URL;
		} else {
			request.setAttribute(REQUEST_PARAM_CPDATA, getCustomerParamsJSONString(customerParams));
			request.setAttribute(REQUEST_PARAM_DATE_OF_BIRTH,
					getDateOfBirthJSONString(customerParams.get(REQUEST_PARAM_DATE_OF_BIRTH)));
			return PAGE_CHANGE_ORDER;
		}
	}

	@SuppressWarnings("unchecked")
	private String getCustomerParamsJSONString(Map<String, String> customerParams) {
		JSONObject resultJson = new JSONObject();
		resultJson.put(REQUEST_PARAM_NAME, customerParams.get(REQUEST_PARAM_CUSTOMER_NAME));
		resultJson.put(REQUEST_PARAM_SURNAME, customerParams.get(REQUEST_PARAM_CUSTOMER_SURNAME));
		resultJson.put(REQUEST_PARAM_PASSPORT_NUMB.replace("_n", "N"), customerParams.get(REQUEST_PARAM_PASSPORT_NUMB));
		resultJson.put(REQUEST_PARAM_DATE_OF_BIRTH.replace("_of_b", "OfB"),
				customerParams.get(REQUEST_PARAM_DATE_OF_BIRTH));
		resultJson.put(REQUEST_PARAM_DRIVING_EXP.replace("_e", "E"), customerParams.get(REQUEST_PARAM_DRIVING_EXP));
		resultJson.put(PARAM_ID, customerParams.get(REQUEST_PARAM_CUSTOMER_ID));
		return resultJson.toJSONString();
	}

	@SuppressWarnings("unchecked")
	private String getDateOfBirthJSONString(String dateOfBirth) {
		JSONObject resultJson = new JSONObject();
		resultJson.put(VALUE, dateOfBirth);
		return resultJson.toJSONString();
	}

}
