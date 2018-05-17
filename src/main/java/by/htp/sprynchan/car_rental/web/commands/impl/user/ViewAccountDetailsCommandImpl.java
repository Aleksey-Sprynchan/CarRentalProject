package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ACCOUNT_SETTINGS;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewAccountDetailsCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);		
		request.setAttribute(REQUEST_PARAM_USER, user);
		return PAGE_USER_ACCOUNT_SETTINGS;
	}
	
}
