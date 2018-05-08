package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ACCOUNT_DETAILS;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ACCOUNT_INFO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangeAccountInfoCommandImpl implements BaseCommand {

	private UserService userService = new UserServiceImpl();

	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_SURNAME = "surname";
	private static final String PARAMETER_EMAIL = "email";
	private static final String PARAMETER_MESSAGE = "info_message";

	public ChangeAccountInfoCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		String newName = request.getParameter(PARAMETER_NAME);
		String newSurname = request.getParameter(PARAMETER_SURNAME);
		String newEmail = request.getParameter(PARAMETER_EMAIL);

		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		user.setName(newName);
		user.setSurname(newSurname);
		user.setEmail(newEmail);

		String message = userService.updateUserInfo(user);
		if (message == null) {
			return PAGE_USER_ACCOUNT_DETAILS;
		} else {
			request.setAttribute(PARAMETER_MESSAGE, message);
			return PAGE_CHANGE_ACCOUNT_INFO;
		}
	}

}
