package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

public interface DamageDao extends BaseDao<Damage> {
	
	List<Damage> readOrderDamages(int orderId) throws DAOException;	
	List<Integer> readUniqueOrdersId(int carId) throws DAOException;		
	int countOrderDamageAmount(int orderId) throws DAOException;

}
