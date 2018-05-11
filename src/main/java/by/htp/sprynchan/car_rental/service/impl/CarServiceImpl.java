package by.htp.sprynchan.car_rental.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import by.htp.login.exception.BookCatalogNotFoundException;
import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.CarDao;
import by.htp.sprynchan.car_rental.dao.impl.CarDaoDBImpl;
import by.htp.sprynchan.car_rental.service.CarService;

public class CarServiceImpl implements CarService {

	private CarDao carDao = new CarDaoDBImpl();

	public CarServiceImpl() {
		super();
	}

	@Override
	public List<Car> getCarPark() {
		return carDao.readAll();		
	}
	
	@Override
	public List<Car> getAvailableCarPark() {	
		return carDao.readAllAvailable();	
	}


	@Override
	public void addCarToCarPark(Car car) {
		carDao.create(car);
	}

	@Override
	public Set<String> getBrandList() {

		List<Car> cars = carDao.readAll();
		Set<String> brandList = new HashSet<String>();
		for (Car car : cars) {
			brandList.add(car.getBrandName());
		}
		return brandList;
	}

	@Override
	public Car getCar(int id) {		
		return carDao.read(id);	
	}
	
	@Override
	public void deleteCarFromCarPark(int id) {				
		carDao.setUnavailableStatus(id);	
	}

	@Override
	public void updateCarInfo(Car car) {		
		carDao.update(car);	
	}
	
}
