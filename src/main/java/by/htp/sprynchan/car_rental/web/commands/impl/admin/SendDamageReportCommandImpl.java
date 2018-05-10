package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ADMIN_PROFILE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.CommonAdminCommand;

public class SendDamageReportCommandImpl extends CommonAdminCommand implements BaseCommand {
	
	private OrderService orderService = new OrderServiceImpl();
	private DamageService damageService = new DamageServiceImpl();
	
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_DAMAGE = "damage";
	private static final String PARAMETER_MESSAGE = "info_message";
	private static final String MESSAGE_VALUE = "Damage payment amount has been sent to customer";
	public static final String PARAMETER_CAR_ID = "car_id";
	public static final String PARAMETER_DAMAGE_NAME = "damage_name";
	public static final String PARAMETER_DAMAGE_COST = "damage_cost";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		String[] damageNames = request.getParameterValues(PARAMETER_DAMAGE_NAME);		
		String[] damageCosts = request.getParameterValues(PARAMETER_DAMAGE_COST);
		
		addInputDamages(damageNames, damageCosts, orderId, carId);
				
		int totalAmount = damageService.getTotalDamageAmount(orderId);
		orderService.sendDamagesAmount(orderId, totalAmount);
		setAttributetOrderList(request, null);
		setAttributetOrderStatusList(request);
		request.setAttribute(PARAMETER_MESSAGE, MESSAGE_VALUE);
		return PAGE_ADMIN_PROFILE;
	}
	
	private void addInputDamages(String[] damageNames, String[] damageCosts, int orderId, int carId) {
		
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
