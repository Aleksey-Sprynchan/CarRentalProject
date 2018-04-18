package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_BEFORE_INDEX;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_USER_PROFILE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class ToMyProfilePageCommandImpl extends CommonAdminCommand implements BaseCommand {

	private CarService carService = new CarServiceImpl();

	private static final String PARAMETER_CAR_LIST = "car_list";
	private static final String PARAMETER_USER_TYPE = "user_type";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		UserTypeEnum userType = (UserTypeEnum) request.getSession().getAttribute(PARAMETER_USER_TYPE);

		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(PARAMETER_CAR_LIST, carList);

		if (userType == UserTypeEnum.ADMIN) {
			setAttributetOrderList(request, null);
			setAttributetOrderStatusList(request);
			return PAGE_ADMIN_PROFILE;
		} else if (userType == UserTypeEnum.USER) {
			return PAGE_USER_PROFILE;
		} else {
			return PAGE_BEFORE_INDEX;
		}

	}

}
