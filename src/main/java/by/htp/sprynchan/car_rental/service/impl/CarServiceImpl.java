package by.htp.sprynchan.car_rental.service.impl;

import static by.htp.sprynchan.car_rental.service.util.ServiceInputParamNullValidator.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.CarDao;
import by.htp.sprynchan.car_rental.dao.factory.DAOFactory;
import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public class CarServiceImpl implements CarService {

	private CarDao carDao = DAOFactory.getCarDAO();

	@Override
	public List<Car> getCarPark() throws ServiceException {
		return carDao.readAll();
	}

	@Override
	public List<Car> getAvailableCarPark() throws ServiceException {
		return carDao.readAllByStatus(true);
	}

	@Override
	public void addCarToCarPark(Car car) throws ServiceException {
		validateInputParamNotNull(car);
		carDao.create(car);
	}

	@Override
	public Set<String> getBrandList() throws ServiceException {
		List<Car> cars = carDao.readAll();
		Set<String> brandList = new HashSet<>();
		for (Car car : cars) {
			brandList.add(car.getBrandName());
		}
		return brandList;
	}

	@Override
	public Car getCar(int id) throws ServiceException {
		return carDao.read(id);
	}

	@Override
	public void deleteCarFromCarPark(int id) throws ServiceException {
		carDao.setUnavailableStatus(id);
	}

	@Override
	public void updateCarInfo(Car car) throws ServiceException {
		validateInputParamNotNull(car);
		carDao.update(car);
	}

	@Override
	public List<Car> getInactiveCarPark() throws ServiceException {
		return carDao.readAllByStatus(false);
	}

}
