package by.htp.sprynchan.car_rental.service;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public interface CustomerPersonalDataService {
	
	CustomerPersonalData getCustomerPersonalData(int id) throws ServiceException;	
	void changeCustomerInfo(CustomerPersonalData customer) throws ServiceException;	
}
