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
	}

	@Override
	public List<Car> getCarPark() {

		List<Car> carList = carDao.readAll();
		if (carList.isEmpty()) {
			// throw new BookCatalogNotFoundException();
		} else {
			return carList;
		}

		return carList;
	}
	
	@Override
	public List<Car> getAvailableCarPark() {
		
		List<Car> carList = carDao.readAllAvailable();
		if (carList.isEmpty()) {
			// throw new BookCatalogNotFoundException();
		} else {
			return carList;
		}

		return carList;
		
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
	public void updateIsAvailableStatus(int id, String command) {
		
		Car car = carDao.read(id);
		
		if(command.equals("CREATE_ORDER")) {
			car.setAvailable(false);					
		} else if(command.equals("MARK_AS_RETURNED") || command.equals("REJECT_ORDER")) {
			car.setAvailable(true);
		} else {
			throw new IllegalArgumentException();
		}
		
		carDao.update(car);
		
	}

	@Override
	public void deleteCarFromCarPark(int id) {
		
		carDao.delete(id);
		
	}

	@Override
	public void updateCarInfo(Car car) {
		
		carDao.update(car);
		
	}
	
	
}
