package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CAR_DAMAGE_HISTORY;
import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ViewCarDamageHistoryCommandImpl implements BaseCommand {
	
	private DamageService damageService = new DamageServiceImpl();
	
	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		
		int carId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CAR_ID));
		Map<Integer, List<Damage>> carDamageHistoryMap = damageService.getCarDamageHistory(carId);
		Set<Integer> orderIdSet = carDamageHistoryMap.keySet();	
		request.setAttribute(REQUEST_PARAM_CAR_DAMAGE_HISTORY_MAP, carDamageHistoryMap);
		request.setAttribute(REQUEST_PARAM_ORDER_SET, orderIdSet);	
		return PAGE_CAR_DAMAGE_HISTORY;
	}

}
