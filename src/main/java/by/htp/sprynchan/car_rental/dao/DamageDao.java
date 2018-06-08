package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

/**
 * Interface that provides additional methods 
 * to access damages data from database.
 * 
 * @author Aleksey Sprynchan
 */
public interface DamageDao extends BaseDao<Damage> {
	
	/**
	 * Gets all damages for current order
	 * 
	 * @param orderId
	 * @return List of damages 
	 * @throws DAOException
	 */
	List<Damage> readOrderDamages(int orderId) throws DAOException;	
	
	/**
	 * Gets distinct orders id where damages were detected
	 * 
	 * @param carId
	 * @return List of orders id
	 * @throws DAOException
	 */
	List<Integer> readUniqueOrdersId(int carId) throws DAOException;		
	
	/**
	 * Counts total damage amount for current order directly
	 * from database
	 * 
	 * @param orderId
	 * @return total damage amount
	 * @throws DAOException
	 */
	int countOrderDamageAmount(int orderId) throws DAOException;

}
