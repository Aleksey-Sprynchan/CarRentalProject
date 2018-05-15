package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USERS_LIST;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewUserListCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		request.setAttribute(REQUEST_PARAM_USER_LIST, userService.getUsersList());
		return PAGE_USERS_LIST;
	}

}
