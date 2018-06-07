package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class ChangeLocaleCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String locale = request.getParameter(REQUEST_PARAM_LOCALE);
		request.getSession().setAttribute(REQUEST_PARAM_LOCALE, locale);
		UserTypeEnum userType = (UserTypeEnum) request.getSession().getAttribute(REQUEST_PARAM_USER_TYPE);
		if (userType == UserTypeEnum.ADMIN) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			return REDIRECT_ADMIN_URL;
		} else if (userType == UserTypeEnum.USER) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			return REDIRECT_USER_URL;
		} else {
			return REDIRECT_GUEST_URL;
		}
	}

}
