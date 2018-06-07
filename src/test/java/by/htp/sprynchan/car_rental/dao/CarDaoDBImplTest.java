package by.htp.sprynchan.car_rental.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.impl.CarDaoDBImpl;

public class CarDaoDBImplTest {
	
	private CarDao carDao;
	
	@Before
	public void initCarDao() {
		carDao = new CarDaoDBImpl();
	}
	
	@Test
	public void createCarTest() throws Exception {
		boolean result = true;
		if(carDao.create(new Car()) == 0) {
			result = false;
		}
		assertTrue(result);
	}

}
