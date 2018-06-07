package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_SIGN_IN;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class AuthorizationCommandImpl implements BaseCommand {

	private static final String MESSAGE_VALUE = "message_incorrect_login_password";
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String pass = request.getParameter(REQUEST_PARAM_PASS);
		validateParamNotNull(login);
		validateParamNotNull(pass);
		User user = userService.getUserByLoginPassword(login, pass);
		return checkRecievedUser(user, request);
	}

	private String checkRecievedUser(User user, HttpServletRequest request) {
		if (user != null) {
			request.getSession().setAttribute(REQUEST_PARAM_USER, user);
			return identifyUserType(user, request);
		} else {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, Resource.getStrLocale(MESSAGE_VALUE, request));
			return PAGE_SIGN_IN;
		}
	}

	private String identifyUserType(User user, HttpServletRequest request) {
		if (user.isAdmin()) {
			request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.ADMIN);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			return REDIRECT_ADMIN_URL;
		} else {
			request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.USER);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			return REDIRECT_USER_URL;
		}
	}

}
