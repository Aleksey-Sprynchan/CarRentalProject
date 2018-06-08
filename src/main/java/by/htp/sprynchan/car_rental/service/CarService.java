package by.htp.sprynchan.car_rental.service;

import java.util.List;
import java.util.Set;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

/**
 * Interface provides methods
 * for working with Car entity.
 * 
 * @author Aleksey Sprynchan
 *
 */
public interface CarService {
	
	/**
	 * Gets full car park
	 * 
	 * @return List of cars
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Car> getCarPark() throws ServiceException;
	
	/**
	 * Gets available cars for rent
	 * 
	 * @return List of available cars
	 * @throws ServiceException ServiceException if DAOException was thrown
	 */
	List<Car> getAvailableCarPark() throws ServiceException;
	
	/**
	 * Gets unavailable cars
	 * 
	 * @return List of unavailable cars
	 * @throws ServiceException if DAOException was thrown
	 */
	List<Car> getInactiveCarPark() throws ServiceException;
	
	/** 
	 * Adds car to car park
	 * 
	 * @param Car entity
	 * @throws ServiceException if DAOException was thrown
	 */
	void addCarToCarPark(Car car) throws ServiceException;
	
	/**
	 * Gets unique car brands
	 * 
	 * @return Set of brand names
	 * @throws ServiceException if DAOException was thrown
	 */
	Set<String> getBrandList() throws ServiceException;
	
	/**
	 * Gets car
	 * 
	 * @param car id
	 * @return Car entity
	 * @throws ServiceException if DAOException was thrown
	 */
	Car getCar(int id) throws ServiceException;
	
	/**
	 * Deletes car from car park
	 * 
	 * @param car id
	 * @throws ServiceException if DAOException was thrown
	 */
	void deleteCarFromCarPark(int id) throws ServiceException;
	
	/**
	 * Update info about certain car
	 * 
	 * @param Car entity
	 * @throws ServiceException if DAOException was thrown
	 */
	void updateCarInfo(Car car) throws ServiceException;
}
