package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.UserNotFoundException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class AuthorizationCommandImpl extends CommonAdminCommand  implements BaseCommand {

	private UserService userService = new UserServiceImpl();
	private CarService carService = new CarServiceImpl();

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_USER = "user";
	private static final String PARAMETER_USER_TYPE = "user_type";
	private static final String PARAMETER_CAR_LIST = "car_list";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response)
			throws UserNotFoundException {

		User resultUser = userService.getUserByLoginPassword(request.getParameter(PARAMETER_LOGIN),
				request.getParameter(PARAMETER_PASSWORD));

		if (resultUser != null) {
			request.getSession().setAttribute(PARAMETER_USER, resultUser);
			if (resultUser.isAdmin()) {
				return getAdminProfilePage(request, response);
			} else {
				return getUserProfilePage(request, response, resultUser);
			}

		} else {
			// TODO to index page
			throw new UserNotFoundException();
		}
	}

	
	private String getAdminProfilePage(HttpServletRequest request, HttpServletResponse response) {	
		
		request.getSession().setAttribute(PARAMETER_USER_TYPE, UserTypeEnum.ADMIN);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
			
		return PAGE_ADMIN_PROFILE;
	}

	
	private String getUserProfilePage(HttpServletRequest request, HttpServletResponse response, User resultUser) {
		
		request.getSession().setAttribute(PARAMETER_USER_TYPE, UserTypeEnum.USER);
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(PARAMETER_CAR_LIST, carList);
		request.setAttribute(PARAMETER_USER, resultUser);		
		
		return PAGE_USER_PROFILE;
	}

}
