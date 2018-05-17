package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangeAccountInfoCommandImpl implements BaseCommand {

	private UserService userService = new UserServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		String newName = request.getParameter(REQUEST_PARAM_NAME);
		String newSurname = request.getParameter(REQUEST_PARAM_SURNAME);
		String newEmail = request.getParameter(REQUEST_PARAM_EMAIL);
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		user.setName(newName);
		user.setSurname(newSurname);
		user.setEmail(newEmail);

		String message = userService.updateUserInfo(user);
		if (message == null) {		
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ACCOUNT_SETTINGS);
			return REDIRECT_USER_URL;
		} else {		
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, message);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_ACCOUNT_INFO);
			return REDIRECT_USER_URL;
		}
	}

}
