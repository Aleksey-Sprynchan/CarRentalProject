package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class RegisterCommandImpl implements BaseCommand {

	private UserService userService = new UserServiceImpl();
	
	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_SURNAME = "surname";
	private static final String PARAMETER_EMAIL = "email";
	private static final String PARAMETER_DUPLICATE_MESSAGE = "dup_message";

	
	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		String login = request.getParameter(PARAMETER_LOGIN);
		String password = request.getParameter(PARAMETER_PASSWORD);
		String name = request.getParameter(PARAMETER_NAME);
		String surname = request.getParameter(PARAMETER_SURNAME);
		String email = request.getParameter(PARAMETER_EMAIL);
		
		String message = userService.createNewUser(login, password, name, surname, email);	
		if(message ==null) {
			return PAGE_INDEX;
		} else {
			request.setAttribute(PARAMETER_DUPLICATE_MESSAGE, message);
			return PAGE_REGISTRATION;
		}
	}

}
