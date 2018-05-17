package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class AuthorizationCommandImpl implements BaseCommand {

	private UserService userService = new UserServiceImpl();
	
	private static final String MESSAGE_USER_NOT_FOUND = "Incorrect login or password!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		User user = userService.getUserByLoginPassword(request.getParameter(REQUEST_PARAM_LOGIN),
				request.getParameter(REQUEST_PARAM_PASS));

		if (user != null) {
			request.getSession().setAttribute(REQUEST_PARAM_USER, user);
			if (user.isAdmin()) {
				request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.ADMIN);
				request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
				return REDIRECT_ADMIN_URL;
			} else {
				request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.USER);
				request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);				
				return REDIRECT_USER_URL;
			}
		} else {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_USER_NOT_FOUND);
			return PAGE_INDEX;
		}
	}

}
