package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REPORT_DAMAGES;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class AddDamageCommandImpl implements BaseCommand {
	
	private DamageService damageService = new DamageServiceImpl();
	
	public static final String PARAMETER_ORDER_ID = "order_id";
	public static final String PARAMETER_CAR_ID = "car_id";
	public static final String PARAMETER_DAMAGE_NAME = "damage_name";
	public static final String PARAMETER_DAMAGE_COST = "damage_cost";

	public AddDamageCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {

		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		Damage damage = new Damage();
		damage.setCarId(carId);
		damage.setOrderId(orderId);
		damage.setDamageName(request.getParameter(PARAMETER_DAMAGE_NAME));
		damage.setDamageCost(Integer.parseInt(request.getParameter(PARAMETER_DAMAGE_COST)));
		damageService.addDamage(damage);
		
		request.setAttribute(PARAMETER_ORDER_ID, orderId);
		request.setAttribute(PARAMETER_CAR_ID, carId);
		
		return PAGE_REPORT_DAMAGES;
	}

}
