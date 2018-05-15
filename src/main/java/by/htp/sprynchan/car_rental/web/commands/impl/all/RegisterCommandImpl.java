package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REGISTRATION;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class RegisterCommandImpl implements BaseCommand {

	private UserService userService = new UserServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASS);
		String name = request.getParameter(REQUEST_PARAM_NAME);
		String surname = request.getParameter(REQUEST_PARAM_SURNAME);
		String email = request.getParameter(REQUEST_PARAM_EMAIL);
		User user = new User(login, password, name, surname, email);
		
		String message = userService.createNewUser(user);	
		if(message == null) {
			return PAGE_INDEX;
		} else {
			request.setAttribute(REQUEST_PARAM_DUPLICATE_MESSAGE, message);
			return PAGE_REGISTRATION;
		}
	}

}
