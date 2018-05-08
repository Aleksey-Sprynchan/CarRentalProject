package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Car;

public interface CarDao extends BaseDao<Car> {
	
	List<Car> readAll();	
	List<Car> readAllAvailable();
	
}
