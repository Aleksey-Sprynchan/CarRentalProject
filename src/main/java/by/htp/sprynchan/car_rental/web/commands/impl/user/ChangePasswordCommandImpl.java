package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_PASSWORD;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ChangePasswordCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	
	private static final String PARAMETER_OLD_PASSWORD = "old_password";
	private static final String PARAMETER_NEW_PASSWORD = "new_password";
	private static final String PARAMETER_CONFIRM_NEW_PASSWORD = "confirm_new_password";
	
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String PARAMETER_MESSAGE_WRONG_OLD_PASSWORD = "Wrong old password!";
	private static final String PARAMETER_MESSAGE_WRONG_CONFIRMATION = "Password confirmation didn't match. Try again!";
	private static final String PARAMETER_MESSAGE_PASSWORD_CHANGED = "Password was succsessfully changed!";
	

	public ChangePasswordCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		String oldPassword = request.getParameter(PARAMETER_OLD_PASSWORD);
		String newPassword = request.getParameter(PARAMETER_NEW_PASSWORD);
		String confrimNewPassword = request.getParameter(PARAMETER_CONFIRM_NEW_PASSWORD);
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		if(!user.getPassword().equals(oldPassword)) {
			request.setAttribute(PARAMETER_MESSAGE, PARAMETER_MESSAGE_WRONG_OLD_PASSWORD);
			return PAGE_CHANGE_PASSWORD;
		} else if(!newPassword.equals(confrimNewPassword)) {
			request.setAttribute(PARAMETER_MESSAGE, PARAMETER_MESSAGE_WRONG_CONFIRMATION);
			return PAGE_CHANGE_PASSWORD;
		}
		
		user.setPassword(newPassword);
		userService.changeUserPassword(user);
		request.setAttribute(PARAMETER_MESSAGE, PARAMETER_MESSAGE_PASSWORD_CHANGED);
		request.getSession().invalidate();
		return PAGE_INDEX;

	}

}
