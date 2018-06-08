package by.htp.sprynchan.car_rental.service;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

/**
 * Interface provides methods
 * for working with CustomerPersonalData entity.
 * 
 * @author Aleksey Sprynchan
 *
 */
public interface CustomerPersonalDataService {
	
	/**
	 * Gets CustomerPersonalData entity
	 * 
	 * @param CustomerPersonalData id
	 * @return CustomerPersonalData entity
	 * @throws ServiceException if DAOException was thrown
	 */
	CustomerPersonalData getCustomerPersonalData(int id) throws ServiceException;	
	
	/**
	 * Changes CustomerPersonalData entity info
	 * 
	 * @param CustomerPersonalData entity
	 * @throws ServiceException if DAOException was thrown
	 */
	void changeCustomerInfo(CustomerPersonalData customer) throws ServiceException;	
}
