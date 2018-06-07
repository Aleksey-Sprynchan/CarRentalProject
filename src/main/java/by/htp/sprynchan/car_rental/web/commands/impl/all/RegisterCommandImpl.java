package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REGISTRATION;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public class RegisterCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_VALUE = "success_registration";
	private static final String SUCCESS = "success";
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		User user = newUser(request);
		if (validateNewUser(user, request)) {
			String message = userService.createNewUser(user);
			return resultPage(message, user, request);
		} else {
			request.setAttribute(REQUEST_PARAM_NEW_USER, user);
			return PAGE_REGISTRATION;
		}
	}

	private User newUser(HttpServletRequest request) {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASS);
		String name = request.getParameter(REQUEST_PARAM_NAME);
		String surname = request.getParameter(REQUEST_PARAM_SURNAME);
		String email = request.getParameter(REQUEST_PARAM_EMAIL);
		return new User(login, password, name, surname, email);
	}

	private String resultPage(String message, User user, HttpServletRequest request) {
		if (SUCCESS.equals(message)) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_GUEST_URL;
		} else {
			request.setAttribute(REQUEST_PARAM_DUPLICATE_MESSAGE, message);
			request.setAttribute(REQUEST_PARAM_NEW_USER, user);
			return PAGE_REGISTRATION;
		}
	}

	protected boolean validateNewUser(User user, HttpServletRequest request) throws ValidateNullRequestParamException {

		boolean result = true;
		if (!validateLogin(user.getLogin())) {
			request.setAttribute(REQUEST_PARAM_INVALID_LOGIN,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_LOGIN, request));
			result = false;
		}
		if (!validatePassword(user.getPassword())) {
			request.setAttribute(REQUEST_PARAM_INVALID_PASS,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_PASS, request));
			result = false;
		}
		if (!validateName(user.getName())) {
			request.setAttribute(REQUEST_PARAM_INVALID_NAME,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_NAME, request));
			result = false;
		}
		if (!validateSurname(user.getSurname())) {
			request.setAttribute(REQUEST_PARAM_INVALID_SURNAME,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_SURNAME, request));
			result = false;
		}
		if (!validateEmail(user.getEmail())) {
			request.setAttribute(REQUEST_PARAM_INVALID_EMAIL,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_EMAIL, request));
			result = false;
		}
		return result;
	}

}
