package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_CAR_DAMAGE_HISTORY;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.impl.DamageServiceImpl;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class ViewCarDamageHistoryCommandImpl implements BaseCommand {
	
	private DamageService damageService = new DamageServiceImpl();
	
	private static final String PARAMETER_CAR_ID = "car_id";
	public static final String PARAMETER_CAR_DAMAGE_HISTORY_MAP = "carDamHist_map";
	public static final String PARAMETER_ORDER_SET = "order_set";

	public ViewCarDamageHistoryCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int carId = Integer.parseInt(request.getParameter(PARAMETER_CAR_ID));
		Map<Integer, List<Damage>> carDamageHistoryMap = damageService.getCarDamageHistory(carId);
		Set<Integer> orderSet = carDamageHistoryMap.keySet();
		
		request.setAttribute(PARAMETER_CAR_DAMAGE_HISTORY_MAP, carDamageHistoryMap);
		request.setAttribute(PARAMETER_ORDER_SET, orderSet);
		
		return PAGE_CAR_DAMAGE_HISTORY;
	}

}
