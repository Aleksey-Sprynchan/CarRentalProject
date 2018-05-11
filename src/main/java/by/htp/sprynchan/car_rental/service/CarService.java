package by.htp.sprynchan.car_rental.service;


import java.util.List;
import java.util.Set;

import by.htp.sprynchan.car_rental.bean.Car;

public interface CarService {
	
	List<Car> getCarPark();
	List<Car> getAvailableCarPark();
	void addCarToCarPark(Car car);
	Set<String> getBrandList();
	Car getCar(int id);
	void deleteCarFromCarPark(int id);
	void updateCarInfo(Car car);
}
