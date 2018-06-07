package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class DeleteAccountCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_VALUE = "success_delete_account";
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		userService.deleteUser(user.getId());
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, Resource.getStrLocale(MESSAGE_VALUE, request));
		return REDIRECT_GUEST_URL;
	}

}
