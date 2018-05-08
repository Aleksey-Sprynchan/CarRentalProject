package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	private static final String PARAMETER_DEPOSIT_AMMOUNT = "deposit_ammount";
	private static final String PARAMETER_USER= "user";
	
	private CarService carService = new CarServiceImpl();

	private static final String PARAMETER_CAR_LIST = "car_list";

	public MakeDepositCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int depositAmmount = Integer.parseInt(request.getParameter(PARAMETER_DEPOSIT_AMMOUNT));
		User user = (User)request.getSession().getAttribute(PARAMETER_USER);
		int newBalance = user.getBalance() + depositAmmount;
		user.setBalance(newBalance);
		userService.changeUserBalance(user);
		
		request.getSession().setAttribute(PARAMETER_USER, userService.getUser(user.getId()));
		
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(PARAMETER_CAR_LIST, carList);
	
		return PAGE_USER_PROFILE;
	}

}
