package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@Override
	public String executeCommand(HttpServletRequest request) throws UserNotFoundException {

		User user = userService.getUserByLoginPassword(request.getParameter(REQUEST_PARAM_LOGIN),
				request.getParameter(REQUEST_PARAM_PASS));

		if (user != null) {
			request.getSession().setAttribute(REQUEST_PARAM_USER, user);
			if (user.isAdmin()) {
				return getAdminProfilePage(request);
			} else {
				return getUserProfilePage(request, user);
			}
		} else {
			// TODO to index page
			throw new UserNotFoundException();
		}
	}
	
	private String getAdminProfilePage(HttpServletRequest request) {		
		request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.ADMIN);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);		
		return PAGE_ADMIN_PROFILE;
	}
	
	private String getUserProfilePage(HttpServletRequest request, User user) {	
		request.getSession().setAttribute(REQUEST_PARAM_USER_TYPE, UserTypeEnum.USER);
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		request.setAttribute(REQUEST_PARAM_USER, user);			
		return PAGE_USER_PROFILE;
	}

}
