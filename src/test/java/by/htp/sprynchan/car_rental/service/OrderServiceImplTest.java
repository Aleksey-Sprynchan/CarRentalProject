package by.htp.sprynchan.car_rental.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.sprynchan.car_rental.service.impl.OrderServiceImpl;

public class OrderServiceImplTest {

	private OrderService orderService;

	@Before
	public void initOrderService() {
		orderService = new OrderServiceImpl();
	}

	@Test
	public void testUnfinishedOrders() throws Exception {
		if (orderService.checkForUnfinishedOrders(1)) {
			fail();
		}
	}

}
