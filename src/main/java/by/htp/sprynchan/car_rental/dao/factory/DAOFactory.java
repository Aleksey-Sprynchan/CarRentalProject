package by.htp.sprynchan.car_rental.dao.factory;

import by.htp.sprynchan.car_rental.dao.CarDao;
import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;
import by.htp.sprynchan.car_rental.dao.DamageDao;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.impl.*;

/**
 * Class that provides instances of DAO 
 * 
 * @author Aleksey Sprynchan
 *      
 */
public class DAOFactory {

	private DAOFactory() {
		throw new IllegalStateException("Utility class");
	}

	public static CarDao getCarDAO() {
		return new CarDaoDBImpl();
	}

	public static CustomerPersonalDataDao getCustomerPersonalDataDAO() {
		return new CustomerPersonalDataDaoDBImpl();
	}

	public static DamageDao getDamageDAO() {
		return new DamageDaoDBImpl();
	}

	public static OrderDao getOrderDAO() {
		return new OrderDaoDBImpl();
	}

	public static UserDao getUserDAO() {
		return new UserDaoDBImpl();
	}

}
