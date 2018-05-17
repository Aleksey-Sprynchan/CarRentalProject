package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ChangePasswordCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	
	private static final String MESSAGE_WRONG_OLD_PASS = "Wrong old password!";
	private static final String MESSAGE_WRONG_CONFIRMATION = "Password confirmation didn't match. Try again!";
	private static final String MESSAGE_PASS_CHANGED = "Password was succsessfully changed!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		
		String oldPass = request.getParameter(REQUEST_PARAM_OLD_PASS);
		String newPassw = request.getParameter(REQUEST_PARAM_NEW_PASS);
		String confrimNewPass = request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS);	
		
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		if(!user.getPassword().equals(oldPass)) {			
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_WRONG_OLD_PASS);
			return REDIRECT_USER_URL;		
		} else if(!newPassw.equals(confrimNewPass)) {	
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_WRONG_CONFIRMATION);
			return REDIRECT_USER_URL;		
		}
		
		user.setPassword(newPassw);
		userService.changeUserPassword(user);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_PASS_CHANGED);	
		return REDIRECT_GUEST_URL;	
	}
	

}
