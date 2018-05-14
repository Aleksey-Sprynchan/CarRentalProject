package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_PASS;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangePasswordCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	
	private static final String MESSAGE_WRONG_OLD_PASSW = "Wrong old password!";
	private static final String MESSAGE_WRONG_CONFIRMATION = "Password confirmation didn't match. Try again!";
	private static final String MESSAGE_PASS_CHANGED = "Password was succsessfully changed!";

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		String oldPassword = request.getParameter(REQUEST_PARAM_OLD_PASS);
		String newPassword = request.getParameter(REQUEST_PARAM_NEW_PASS);
		String confrimNewPassword = request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS);
		
		User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		if(!user.getPassword().equals(oldPassword)) {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_WRONG_OLD_PASSW);
			return PAGE_CHANGE_PASS;
		} else if(!newPassword.equals(confrimNewPassword)) {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_WRONG_CONFIRMATION);
			return PAGE_CHANGE_PASS;
		}
		
		user.setPassword(newPassword);
		userService.changeUserPassword(user);
		request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_PASS_CHANGED);
		request.getSession().invalidate();
		return PAGE_INDEX;
	}

}
