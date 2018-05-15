package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_START_PAGE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class ToMyProfilePageCommandImpl extends CommonAdminCommand implements BaseCommand {

	private CarService carService = new CarServiceImpl();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		UserTypeEnum userType = (UserTypeEnum) request.getSession().getAttribute(REQUEST_PARAM_USER_TYPE);
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);

		if (userType == UserTypeEnum.ADMIN) {
			setAttributetOrderList(request, null);
			setAttributetOrderStatusList(request);
			return PAGE_ADMIN_PROFILE;
		} else if (userType == UserTypeEnum.USER) {
			return PAGE_USER_PROFILE;
		} else {
			return PAGE_START_PAGE;
		}
	}

}
