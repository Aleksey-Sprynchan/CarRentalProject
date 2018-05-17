package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.impl.CustomerPersonalDataServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangeOrderCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_VALUE = "Information was succsefully updated!";
	
	private CustomerPersonalDataService customerService = new CustomerPersonalDataServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int customerId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CUSTOMER_ID));
		String customerName = request.getParameter(REQUEST_PARAM_CUSTOMER_NAME);
		String customerSurname = request.getParameter(REQUEST_PARAM_CUSTOMER_SURNAME);
		String passportNumb  = request.getParameter(REQUEST_PARAM_PASSPORT_NUMB);
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter(REQUEST_PARAM_DATE_OF_BIRTH));
		int drivingExp = Integer.parseInt(request.getParameter(REQUEST_PARAM_DRIVING_EXP));
		
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setId(customerId);
		customer.setName(customerName);
		customer.setSurname(customerSurname);
		customer.setPassportNumb(passportNumb);
		customer.setDateOfBirth(dateOfBirth);
		customer.setDrivingExp(drivingExp);
		customerService.changeCustomerInfo(customer);

		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_MY_ORDERS);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_USER_URL;
	}
	

}
