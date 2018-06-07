package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_PERSONAL_INFO;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.user.util.UserCommansHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangingPersonalInfoPageCommandImpl extends UserCommansHelper implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {	
		setReqParamUser(request, REQUEST_PARAM_USER);
		return PAGE_CHANGE_PERSONAL_INFO;
	}
}
