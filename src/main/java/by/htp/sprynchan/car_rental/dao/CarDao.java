package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

public interface CarDao extends BaseDao<Car> {
	
	List<Car> readAll() throws DAOException;	
	List<Car> readAllByStatus(boolean isAvailable) throws DAOException;
	void setUnavailableStatus(int id) throws DAOException;
	
}
