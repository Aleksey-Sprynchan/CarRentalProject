package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class MakeDepositCommandImpl implements BaseCommand {
	
	private UserService userService = new UserServiceImpl();
	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		int depositAmmount = Integer.parseInt(request.getParameter(REQUEST_PARAM_DEPOSIT_AMMOUNT));
		User user = (User)request.getSession().getAttribute(REQUEST_PARAM_USER);
		int newBalance = user.getBalance() + depositAmmount;
		user.setBalance(newBalance);
		userService.changeUserBalance(user);	
		request.getSession().setAttribute(REQUEST_PARAM_USER, userService.getUser(user.getId()));	
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		return PAGE_USER_PROFILE;
	}

}
