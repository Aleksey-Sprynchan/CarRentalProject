package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_ACCOUNT_INFO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangingAccountInfoPageCommandImpl implements BaseCommand {
	
	private static final String PARAMETER_USER = "user";

	public ChangingAccountInfoPageCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		request.setAttribute(PARAMETER_USER, user);
		
		return PAGE_CHANGE_ACCOUNT_INFO;
	}

}
