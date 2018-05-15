package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ACCOUNT_SETTINGS;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ACCOUNT_INFO;
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
			return PAGE_USER_ACCOUNT_SETTINGS;
		} else {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, message);
			return PAGE_CHANGE_ACCOUNT_INFO;
		}
	}

}
