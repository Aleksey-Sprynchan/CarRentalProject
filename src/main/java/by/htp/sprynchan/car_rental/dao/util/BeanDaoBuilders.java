package by.htp.sprynchan.car_rental.dao.util;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class BeanDaoBuilders {

	protected Car buildCar(ResultSet resultSet) throws SQLException {
		Car car = new Car();
		car.setId(resultSet.getInt(CARS_COLUMN_ID));
		car.setBrandName(resultSet.getString(CARS_COLUMN_BRAND_NAME));
		car.setModel(resultSet.getString(CARS_COLUMN_MODEL));
		car.setType(resultSet.getString(CARS_COLUMN_TYPE));
		car.setTransmission(resultSet.getString(CARS_COLUMN_TRANSMISSION));
		car.setPassengers(resultSet.getInt(CARS_COLUMN_PASSENGERS));
		car.setFuel(resultSet.getString(CARS_COLUMN_FUEL));
		car.setAirCondition(resultSet.getBoolean(CARS_COLUMN_IS_AIR_CONDITION));
		car.setPricePerDay(resultSet.getInt(CARS_COLUMN_PRICE_PER_DAY));
		car.setAvailable(resultSet.getBoolean(CARS_COLUMN_IS_AVAILABLE));
		car.setImage(resultSet.getString(CARS_COLUMN_IMAGE));		
		return car;
	}
	
	protected Order buildOrder(ResultSet resultSet) throws SQLException {
		Order order = new Order();
		order.setId(resultSet.getInt(ORDERS_COLUMN_ID));
		order.setStatus(OrderStatusEnum.valueOf(resultSet.getString(ORDERS_COLUMN_STATUS)));
		order.setOrderDate(LocalDate.parse(resultSet.getString(ORDERS_COLUMN_ORDER_DATE)));
		order.setUserId(resultSet.getInt(ORDERS_COLUMN_USER_ID));
		order.setCarId(resultSet.getInt(ORDERS_COLUMN_CAR_ID));
		order.setStartDate(LocalDate.parse(resultSet.getString(ORDERS_COLUMN_START_DATE)));
		order.setEndDate(LocalDate.parse(resultSet.getString(ORDERS_COLUMN_END_DATE)));
		order.setCustomer(new CustomerPersonalData(resultSet.getInt(ORDERS_COLUMN_CUSTOMER_ID)));
		order.setTotalPrice(resultSet.getInt(ORDERS_COLUMN_TOTAL_PRICE));
		order.setInsurance(resultSet.getBoolean(ORDERS_COLUMN_IS_INSURANCE));
		order.setDamaged(resultSet.getBoolean(ORDERS_COLUMN_IS_DAMAGED));
		order.setDamageAmount(resultSet.getInt(ORDERS_COLUMN_DAMAGE_AMOUNT));
		order.setRejectionReason(resultSet.getString(ORDERS_COLUMN_REJECTION_REASON));
		return order;
	}

	protected CustomerPersonalData buildCustomer(ResultSet resultSet) throws SQLException {
		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setId(resultSet.getInt(CUSTPERSDATA_COLUMN_ID));
		customer.setName(resultSet.getString(CUSTPERSDATA_COLUMN_NAME));
		customer.setSurname(resultSet.getString(CUSTPERSDATA_COLUMN_SURNAME));
		customer.setPassportNumb(resultSet.getString(CUSTPERSDATA_COLUMN_PASSPORT_NUMB));
		customer.setDateOfBirth(LocalDate.parse(resultSet.getString(CUSTPERSDATA_COLUMN_DATE_OF_BIRTH)));
		customer.setDrivingExp(resultSet.getInt(CUSTPERSDATA_COLUMN_DRIVING_EXP));
		return customer;
	}
	
	protected Damage buildDamage(ResultSet resultSet) throws SQLException {
		Damage damage = new Damage();
		damage.setId(resultSet.getInt(DAMAGES_COLUMN_ID));
		damage.setOrderId(resultSet.getInt(DAMAGES_COLUMN_ORDER_ID));
		damage.setCarId(resultSet.getInt(DAMAGES_COLUMN_CAR_ID));
		damage.setDamageName(resultSet.getString(DAMAGES_COLUMN_DAMAGE_NAME));
		damage.setDamageCost(resultSet.getInt(DAMAGES_COLUMN_DAMAGE_COST));
		return damage;
	}
	
	protected User buildUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(USERS_COLUMN_ID));
		user.setLogin(resultSet.getString(USERS_COLUMN_LOGIN));
		user.setPassword(resultSet.getString(USERS_COLUMN_PASSWORD));
		user.setName(resultSet.getString(USERS_COLUMN_NAME));
		user.setSurname(resultSet.getString(USERS_COLUMN_SURNAME));
		user.setEmail(resultSet.getString(USERS_COLUMN_EMAIL));
		user.setBalance(resultSet.getInt(USERS_COLUMN_BALANCE));
		user.setAdmin(resultSet.getBoolean(USERS_COLUMN_IS_ADMIN));
		return user;
	}

}
