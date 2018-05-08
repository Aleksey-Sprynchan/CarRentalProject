package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_ACCOUNT_DETAILS;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ViewAccountDetailsCommandImpl implements BaseCommand {
	
	private static final String PARAMETER_USER = "user";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);		
		request.setAttribute(PARAMETER_USER, user);
		return PAGE_USER_ACCOUNT_DETAILS;
	}

}
