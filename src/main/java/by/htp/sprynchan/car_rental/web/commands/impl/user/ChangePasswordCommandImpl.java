package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CHANGE_PASS;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.service.util.PasswordEncryptor;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public class ChangePasswordCommandImpl implements BaseCommand {
	
	private static final String MESSAGE_WRONG_OLD_PASS = "message_wrong_old_pass";
	private static final String MESSAGE_WRONG_CONFIRMATION = "message_pass_confirmation";
	private static final String MESSAGE_PASS_CHANGED = "success_change_pass";
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String oldPass = request.getParameter(REQUEST_PARAM_OLD_PASS);
		String newPass = request.getParameter(REQUEST_PARAM_NEW_PASS);
		String confirmNewPass = request.getParameter(REQUEST_PARAM_CONFIRM_NEW_PASS);
		if (validateNewPassword(newPass, request)) {
			return changePassMainLogic(oldPass, newPass, confirmNewPass, request);
		} else {
			return PAGE_CHANGE_PASS;
		}
	}

	private String changePassMainLogic(String oldPass, String newPass, String confirmNewPass,
			HttpServletRequest request) throws ServiceException {
		User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
		String sessionUserPass = userService.getUserPassword(sessionUser.getId());
		if (checkPasswordData(sessionUserPass, oldPass, newPass, confirmNewPass, request)) {
			User user = new User(sessionUser.getId());
			user.setPassword(newPass);
			userService.changeUserPassword(user);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_PASS_CHANGED, request));
			return REDIRECT_GUEST_URL;
		} else {
			return REDIRECT_USER_URL;
		}

	}

	private boolean checkPasswordData(String sessionUserPass, String oldPass, String newPass, String confirmNewPass,
			HttpServletRequest request) {
		if (!sessionUserPass.equals(PasswordEncryptor.md5Apache(oldPass))) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_WRONG_OLD_PASS, request));
			return false;
		} else if (!newPass.equals(confirmNewPass)) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_CHANGE_PASS);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_WRONG_CONFIRMATION, request));
			return false;
		} else {
			return true;
		}
	}

	private boolean validateNewPassword(String newPass, HttpServletRequest request)
			throws ValidateNullRequestParamException {
		if (!validatePassword(newPass)) {
			request.setAttribute(REQUEST_PARAM_INVALID_PASS,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_PASS, request));
			return false;
		}
		return true;
	}

}
