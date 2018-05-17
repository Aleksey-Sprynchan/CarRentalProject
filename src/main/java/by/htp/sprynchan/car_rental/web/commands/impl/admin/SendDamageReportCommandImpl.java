package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class SendDamageReportCommandImpl implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	private DamageService damageService = new DamageServiceImpl();

	private static final String MESSAGE_VALUE = "Damage payment amount has been sent to customer";

	@Override
	public String executeCommand(HttpServletRequest request) throws CommandException {

		int orderId = Integer.parseInt(request.getParameter(REQUEST_PARAM_ORDER_ID));
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		String[] damageNames = request.getParameterValues(REQUEST_PARAM_DAMAGE_NAME);		
		String[] damageCosts = request.getParameterValues(REQUEST_PARAM_DAMAGE_COST);
		
		addInputDamages(damageNames, damageCosts, orderId, carId);
				
		int totalAmount = damageService.getTotalDamageAmount(orderId);
		orderService.sendDamagesAmount(orderId, totalAmount);

		request.getSession().setAttribute(SESSION_ATR_SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PROFILE);
		request.getSession().setAttribute(SESSION_ATR_SESSION_MESSAGE, MESSAGE_VALUE);
		return REDIRECT_ADMIN_URL;
	}
	
	private void addInputDamages(String[] damageNames, String[] damageCosts, int orderId, int carId) throws ServiceException {		
		Damage damage = new Damage();
		damage.setCarId(carId);
		damage.setOrderId(orderId);
		for(int i = 0; i < damageNames.length; i++) {
			damage.setDamageName(damageNames[i]);
			damage.setDamageCost(Integer.parseInt(damageCosts[i]));
			damageService.addDamage(damage);
		}		
	}
}
