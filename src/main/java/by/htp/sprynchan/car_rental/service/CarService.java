package by.htp.sprynchan.car_rental.service;


import java.util.List;
import java.util.Set;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public interface CarService {
	
	List<Car> getCarPark() throws ServiceException;
	List<Car> getAvailableCarPark() throws ServiceException;
	List<Car> getInactiveCarPark() throws ServiceException;
	void addCarToCarPark(Car car) throws ServiceException;
	Set<String> getBrandList() throws ServiceException;
	Car getCar(int id) throws ServiceException;
	void deleteCarFromCarPark(int id) throws ServiceException;
	void updateCarInfo(Car car) throws ServiceException;
}
