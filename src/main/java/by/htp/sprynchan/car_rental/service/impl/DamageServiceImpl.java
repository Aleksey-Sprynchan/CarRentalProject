package by.htp.sprynchan.car_rental.service.impl;

import static by.htp.sprynchan.car_rental.service.util.ServiceInputParamNullValidator.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.dao.DamageDao;
import by.htp.sprynchan.car_rental.dao.factory.DAOFactory;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public class DamageServiceImpl implements DamageService {
	
	private DamageDao damageDao = DAOFactory.getDamageDAO();

	@Override
	public List<Damage> getOrderDamages(int orderId) throws ServiceException {
		return damageDao.readOrderDamages(orderId);
	}

	@Override
	public Map<Integer, List<Damage>> getCarDamageHistory(int carId) throws ServiceException {		
		Map<Integer, List<Damage>> carDamageHistory = new HashMap<>();
		List<Integer> ordersId = damageDao.readUniqueOrdersId(carId);		
		for(Integer id: ordersId) {
			carDamageHistory.put(id, damageDao.readOrderDamages(id));			
		}
		return carDamageHistory;
	}

	@Override
	public void addDamage(Damage damage) throws ServiceException {
		validateInputParamNotNull(damage);
		damageDao.create(damage);		
	}

	@Override
	public int getTotalDamageAmount(int orderId) throws ServiceException {
		return damageDao.countOrderDamageAmount(orderId);
	}

}
