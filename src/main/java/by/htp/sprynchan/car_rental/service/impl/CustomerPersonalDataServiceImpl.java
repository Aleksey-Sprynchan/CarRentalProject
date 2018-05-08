package by.htp.sprynchan.car_rental.service.impl;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;
import by.htp.sprynchan.car_rental.dao.impl.CustomerPersonalDataDBDaoImpl;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;

public class CustomerPersonalDataServiceImpl implements CustomerPersonalDataService {
	
	CustomerPersonalDataDao customerPersonalDataDao = new CustomerPersonalDataDBDaoImpl();

	public CustomerPersonalDataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CustomerPersonalData getCustomerPersonalData(int id) {
		return customerPersonalDataDao.read(id);

	}

	@Override
	public void changeCustomerInfo(CustomerPersonalData customer) {
		customerPersonalDataDao.update(customer);		
	}

}
