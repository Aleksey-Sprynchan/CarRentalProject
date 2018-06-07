package by.htp.sprynchan.car_rental.service.factory;

import by.htp.sprynchan.car_rental.service.CarService;
import by.htp.sprynchan.car_rental.service.CustomerPersonalDataService;
import by.htp.sprynchan.car_rental.service.DamageService;
import by.htp.sprynchan.car_rental.service.OrderService;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.impl.*;

public class ServiceFactory {

	private ServiceFactory() {
		throw new IllegalStateException("Utility class");
	}
	
	public static CarService getCarService() {
		return new CarServiceImpl();
	}
	
	public static CustomerPersonalDataService getCarCustomerPersonalDataService() {
		return new CustomerPersonalDataServiceImpl();
	}
	
	public static DamageService getDamageService() {
		return new DamageServiceImpl();
	}
	
	public static OrderService getOrderService() {
		return new OrderServiceImpl();
	}
	
	public static UserService getUserService() {
		return new UserServiceImpl();
	}

}
