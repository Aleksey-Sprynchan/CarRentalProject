package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_START_PAGE;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.util.AdminCommandsHelper;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class ToMyProfilePageCommandImpl extends AdminCommandsHelper implements BaseCommand {

	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {		
		UserTypeEnum userType = (UserTypeEnum) request.getSession().getAttribute(REQUEST_PARAM_USER_TYPE);
		List<Car> carList = carService.getAvailableCarPark();
		request.setAttribute(REQUEST_PARAM_CAR_LIST, carList);
		if (userType == UserTypeEnum.ADMIN) {
			setAttributetOrderListAndOrderCarMap(request);
			setAttributetOrderStatusList(request);
			setAttributetOrderUserMap (request);
			return PAGE_ADMIN_PROFILE;
		} else if (userType == UserTypeEnum.USER) {
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_USER_PROFILE);
			return REDIRECT_USER_URL;
		} else {
			return PAGE_START_PAGE;
		}
	}

}
