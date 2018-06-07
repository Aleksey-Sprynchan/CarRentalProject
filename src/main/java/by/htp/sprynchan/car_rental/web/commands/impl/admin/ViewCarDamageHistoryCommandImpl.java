package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CAR_DAMAGE_HISTORY;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ViewCarDamageHistoryCommandImpl implements BaseCommand {

	private DamageService damageService = ServiceFactory.getDamageService();
	private CarService carService = ServiceFactory.getCarService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		if (validatePositiveInt(carId)) {
			Map<Integer, List<Damage>> carDamageHistoryMap = damageService.getCarDamageHistory(formatInt(carId));
			Set<Integer> orderIdSet = carDamageHistoryMap.keySet();
			request.setAttribute(REQUEST_PARAM_CAR_DAMAGE_HISTORY_MAP, carDamageHistoryMap);
			request.setAttribute(REQUEST_PARAM_ORDER_ID_SET, orderIdSet);
			Car car = carService.getCar(formatInt(carId));
			request.setAttribute(REQUEST_PARAM_CAR, car);
			return PAGE_CAR_DAMAGE_HISTORY;
		} else {
			return PAGE_ERROR;
		}
	}

}
