package by.htp.sprynchan.car_rental.service.impl;

import static by.htp.sprynchan.car_rental.service.util.ServiceInputParamNullValidator.*;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;
import by.htp.sprynchan.car_rental.dao.factory.DAOFactory;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public class CustomerPersonalDataServiceImpl implements CustomerPersonalDataService {

	private CustomerPersonalDataDao customerPersonalDataDao = DAOFactory.getCustomerPersonalDataDAO();

	@Override
	public CustomerPersonalData getCustomerPersonalData(int id) throws ServiceException {
		return customerPersonalDataDao.read(id);
	}

	@Override
	public void changeCustomerInfo(CustomerPersonalData customer) throws ServiceException {
		validateInputParamNotNull(customer);
		customerPersonalDataDao.update(customer);
	}

}
