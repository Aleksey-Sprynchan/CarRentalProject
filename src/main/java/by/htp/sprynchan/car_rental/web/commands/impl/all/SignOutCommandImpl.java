package by.htp.sprynchan.car_rental.web.commands.impl.all;


import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class SignOutCommandImpl implements BaseCommand {

//	private static final String PARAMETER_USER= "user";
//	public static final String PARAMETER_USER_TYPE = "user_type";
//	

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		//TODO remove try
//		request.getSession().setAttribute(PARAMETER_USER, null);
//		request.getSession().setAttribute(PARAMETER_USER_TYPE, null);
		
		request.getSession().invalidate();
		return PAGE_INDEX;
	}

}
