package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class DeleteAccountCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String PARAMETER_MESSAGE_ACCOUNT_DELETED = "Account was successfully deleted!";
	

	public DeleteAccountCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		User user = (User) request.getSession().getAttribute(PARAMETER_USER);
		userService.deleteUser(user.getId());
		request.setAttribute(PARAMETER_MESSAGE, PARAMETER_MESSAGE_ACCOUNT_DELETED);
		request.getSession().invalidate();
		return PAGE_INDEX;
	}

}
