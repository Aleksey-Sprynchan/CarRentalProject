package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_PERSONAL_INFO;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public class ChangePersonalInfoCommandImpl implements BaseCommand {
	
	private static final String SUCCESS = "success";
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		User user = newUserData(request);
		if (validateChangedUser(user, request)) {
			String message = userService.updateUserInfo(user);
			return resultPage(message, user, request);
		} else {
			request.setAttribute(REQUEST_PARAM_USER, user);
			return PAGE_CHANGE_PERSONAL_INFO;
		}
	}

	private User newUserData(HttpServletRequest request) {
		User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		User user = new User(sessionUser.getId());
		user.setName(request.getParameter(REQUEST_PARAM_NAME));
		user.setSurname(request.getParameter(REQUEST_PARAM_SURNAME));
		user.setEmail(request.getParameter(REQUEST_PARAM_EMAIL));
		return user;
	}

	private String resultPage(String message, User user, HttpServletRequest request) {
		if (SUCCESS.equals(message)) {
			request.getSession().setAttribute(REQUEST_PARAM_USER, user);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ACCOUNT_SETTINGS);
			return REDIRECT_USER_URL;
		} else {
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, message);
			request.getSession().setAttribute(REQUEST_PARAM_CHANGED_USER, user);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PERSONAL_INFO);
			return REDIRECT_USER_URL;
		}
	}

	private boolean validateChangedUser(User user, HttpServletRequest request)
			throws ValidateNullRequestParamException {

		boolean result = true;
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
