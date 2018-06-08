package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

/**
 * Interface that provides additional methods 
 * to access car data from database.
 * 
 * @author Aleksey Sprynchan
 */
public interface CarDao extends BaseDao<Car> {
	
	/**
	 * Gets all cars from database
	 * 
	 * @return List that contains all cars
	 * @throws DAOException
	 */
	List<Car> readAll() throws DAOException;	
	
	/**
	 * Gets all available cars from database
	 * 
	 * @param isAvailable
	 * @return List that contains available cars
	 * @throws DAOException
	 */
	List<Car> readAllByStatus(boolean isAvailable) throws DAOException;
	
	/**
	 * Sets unavailable status for car (soft delete logic)
	 * 
	 * @param car id
	 * @throws DAOException
	 */
	void setUnavailableStatus(int id) throws DAOException;
	
}
