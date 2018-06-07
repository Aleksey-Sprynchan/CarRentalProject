package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REPORT_DAMAGES;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamFormatter.*;
import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.resources.Resource;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.factory.ServiceFactory;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public class SendDamageReportCommandImpl implements BaseCommand {

	private static final String MESSAGE_VALUE = "success_damage_report";
	private OrderService orderService = ServiceFactory.getOrderService();
	private DamageService damageService = ServiceFactory.getDamageService();

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {
		String orderId = request.getParameter(REQUEST_PARAM_ORDER_ID);
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String[] damageNames = request.getParameterValues(REQUEST_PARAM_DAMAGE_NAME);
		String[] damageCosts = request.getParameterValues(REQUEST_PARAM_DAMAGE_COST);
		if (validateInputData(orderId, carId, damageNames, damageCosts, request)) {
			addInputDamages(damageNames, damageCosts, formatInt(orderId), formatInt(carId));
			int totalAmount = damageService.getTotalDamageAmount(formatInt(orderId));
			orderService.sendDamagesAmount(formatInt(orderId), totalAmount);
			request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
			request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE,
					Resource.getStrLocale(MESSAGE_VALUE, request));
			return REDIRECT_ADMIN_URL;
		} else {
			request.setAttribute(REQUEST_PARAM_ORDER_ID, orderId);
			request.setAttribute(REQUEST_PARAM_CAR_ID, carId);
			return PAGE_REPORT_DAMAGES;
		}
	}

	private void addInputDamages(String[] damageNames, String[] damageCosts, int orderId, int carId)
			throws ServiceException {
		Damage damage = new Damage();
		damage.setCarId(carId);
		damage.setOrderId(orderId);
		for (int i = 0; i < damageNames.length; i++) {
			damage.setDamageName(damageNames[i]);
			damage.setDamageCost(formatInt(damageCosts[i]));
			damageService.addDamage(damage);
		}
	}

	private boolean validateInputData(String orderId, String carId, String[] damageNames, String[] damageCosts,
			HttpServletRequest request) throws ValidateNullRequestParamException {

		boolean result = true;
		if (!validatePositiveInt(orderId) || !validatePositiveInt(carId)) {
			request.setAttribute(REQUEST_PARAM_INVALID_ID, Resource.getStrLocale(REQUEST_PARAM_INVALID_ID, request));
			result = false;
		}
		if (!validateDamageNames(damageNames)) {
			request.setAttribute(REQUEST_PARAM_EMPTY_DAMAGE_NAME,
					Resource.getStrLocale(REQUEST_PARAM_EMPTY_DAMAGE_NAME, request));
			result = false;
		}
		if (!validateDamageCosts(damageCosts)) {
			request.setAttribute(REQUEST_PARAM_INVALID_COST,
					Resource.getStrLocale(REQUEST_PARAM_INVALID_COST, request));
			result = false;
		}
		return result;
	}

}
