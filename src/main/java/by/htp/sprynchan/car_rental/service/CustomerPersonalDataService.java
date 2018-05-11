package by.htp.sprynchan.car_rental.service;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;

public interface CustomerPersonalDataService {
	
	CustomerPersonalData getCustomerPersonalData(int id);	
	void changeCustomerInfo(CustomerPersonalData customer);	
}
