package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.REQUEST_PARAM_INFO_MESSAGE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.REQUEST_PARAM_USER_TYPE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.SESSION_ATR_SESSION_MESSAGE;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class RedirectGuestCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
				request.getSession().getAttribute(SESSION_ATR_SESSION_MESSAGE));
		UserTypeEnum userType = (UserTypeEnum) request.getSession().getAttribute(REQUEST_PARAM_USER_TYPE);
		if (userType == UserTypeEnum.USER) {
			request.getSession().invalidate();
		}
		return PAGE_INDEX;
	}

}
