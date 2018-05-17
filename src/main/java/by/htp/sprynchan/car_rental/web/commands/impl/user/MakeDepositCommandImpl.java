package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class MakeDepositCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		int depositAmmount = formatInt(request.getParameter(REQUEST_PARAM_DEPOSIT_AMMOUNT));
		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		user.setBalance(user.getBalance() + depositAmmount);
		userService.changeUserBalance(user);	
		request.getSession().setAttribute(REQUEST_PARAM_USER, userService.getUser(user.getId()));		
		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);				
		return REDIRECT_USER_URL;
	}

}
