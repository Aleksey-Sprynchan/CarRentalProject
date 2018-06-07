package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class SignOutCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {	
		request.getSession().invalidate();
		return PAGE_INDEX;
	}
	
}
