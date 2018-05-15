package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteAccountCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	
	private static final String MESSAGE_ACCOUNT_DELETED = "Account was successfully deleted!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		userService.deleteUser(user.getId());
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_ACCOUNT_DELETED);
		request.getSession().invalidate();
		return PAGE_INDEX;
	}
}
