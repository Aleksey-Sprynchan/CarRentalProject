package by.htp.sprynchan.car_rental.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.sprynchan.car_rental.service.impl.CarServiceImpl;

public class CarServiceImplTest {

	private CarService carService;

	@Before
	public void initCarService() {
		carService = new CarServiceImpl();
	}

	@Test
	public void checkEmptyBrandList() throws Exception {
		if (carService.getBrandList().size() == 0) {
			fail();
		}
	}

}
