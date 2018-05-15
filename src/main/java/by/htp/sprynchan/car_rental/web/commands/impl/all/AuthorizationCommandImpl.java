package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class AuthorizationCommandImpl extends CommonAdminCommand  implements BaseCommand {

	private UserService userService = new UserServiceImpl();
	private CarService carService = new CarServiceImpl();
	
	private static final String MESSAGE_USER_NOT_FOUND = "Incorrect login or password!";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		User user = userService.getUserByLoginPassword(request.getParameter(REQUEST_PARAM_LOGIN),
				request.getParameter(REQUEST_PARAM_PASS));

		if (user != null) {
			request.getSession().setAttribute(REQUEST_PARAM_USER, user);
			if (user.isAdmin()) {
				return getAdminProfilePage(request);
			} else {
				return getUserProfilePage(request);
			}
		} else {
			request.setAttribute(REQUEST_PARAM_INFO_MESSAGE, MESSAGE_USER_NOT_FOUND);
			return PAGE_INDEX;
		}
	}
	
	private String getAdminProfilePage(HttpServletRequest request) throws ServiceException {		
		request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.ADMIN);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);		
		return PAGE_ADMIN_PROFILE;
	}
	
	private String getUserProfilePage(HttpServletRequest request) throws ServiceException {	
		request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.USER);
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);		
		return PAGE_USER_PROFILE;
	}

}
