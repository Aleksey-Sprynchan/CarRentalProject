package by.htp.sprynchan.car_rental.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.dao.DamageDao;
import by.htp.sprynchan.car_rental.dao.impl.DamageDaoDBImpl;
import by.htp.sprynchan.car_rental.service.DamageService;

public class DamageServiceImpl implements DamageService {
	
	private DamageDao damageDao = new DamageDaoDBImpl();

	@Override
	public List<Damage> getOrderDamages(int orderId) {
		return damageDao.readOrderDamages(orderId);
	}

	@Override
	public Map<Integer, List<Damage>> getCarDamageHistory(int carId) {		
		Map<Integer, List<Damage>> carDamageHistory = new HashMap<>();
		List<Integer> ordersId = damageDao.readUniqueOrdersId(carId);		
		for(Integer id: ordersId) {
			carDamageHistory.put(id, damageDao.readOrderDamages(id));			
		}
		return carDamageHistory;
	}

	@Override
	public void addDamage(Damage damage) {
		damageDao.create(damage);		
	}

	@Override
	public int getTotalDamageAmount(int orderId) {
		return damageDao.countOrderDamageAmount(orderId);
	}

}
