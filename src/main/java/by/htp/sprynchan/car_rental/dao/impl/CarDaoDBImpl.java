package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.CarDao;
import by.htp.sprynchan.car_rental.dao.util.BeanDaoBuilders;

public class CarDaoDBImpl extends BeanDaoBuilders implements CarDao {

	private static final String ADD_CAR = "INSERT INTO cars (brand_name, model, type, transmission, "
			+ "passengers, fuel, is_air_condition, price_per_day, is_available, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String READ_CAR_BY_ID = "SELECT id, brand_name, model, type, transmission, passengers, "
			+ "fuel, is_air_condition, price_per_day, is_available, image FROM cars WHERE id = ?;";

	private static final String UPDATE_CAR_BY_ID = "UPDATE cars SET brand_name = ?, model = ?, type = ?, transmission = ?, "
			+ "passengers = ?, fuel = ?, is_air_condition = ?, price_per_day = ?, is_available = ? "
			+ "image = ? WHERE id = ?;";

	private static final String DELETE_CAR_BY_ID = "DELETE FROM cars WHERE id = ?;";

	private static final String READ_ALL_CARS = "SELECT id, brand_name, model, type, transmission, "
			+ "passengers, fuel, is_air_condition, price_per_day, is_available, image FROM cars;";
	
	private static final String READ_ALL_AVAILABLE_CARS = "SELECT id, brand_name, model, type, transmission, "
			+ "passengers, fuel, is_air_condition, price_per_day, is_available, image FROM cars WHERE is_available = 1;";
	
	private static final String SET_UNAVAILABLE_CAR_STATUS = "UPDATE cars SET is_available = 0 WHERE id = ?;";

	@Override
	public int create(Car entity) {

		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_CAR,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, entity.getBrandName());
			preparedStatement.setString(2, entity.getModel());
			preparedStatement.setString(3, entity.getType());
			preparedStatement.setString(4, entity.getTransmission());
			preparedStatement.setInt(5, entity.getPassengers());
			preparedStatement.setString(6, entity.getFuel());
			preparedStatement.setBoolean(7, entity.isAirCondition());
			preparedStatement.setInt(8, entity.getPricePerDay());
			preparedStatement.setBoolean(9, entity.isAvailable());
			preparedStatement.setString(10, entity.getImage());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return id;
	}

	@Override
	public Car read(int id) {

		Car car = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_CAR_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				car = buildCar(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return car;
	}

	@Override
	public int update(Car entity) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_BY_ID)) {

			preparedStatement.setString(1, entity.getBrandName());
			preparedStatement.setString(2, entity.getModel());
			preparedStatement.setString(3, entity.getType());
			preparedStatement.setString(4, entity.getTransmission());
			preparedStatement.setInt(5, entity.getPassengers());
			preparedStatement.setString(6, entity.getFuel());
			preparedStatement.setBoolean(7, entity.isAirCondition());
			preparedStatement.setInt(8, entity.getPricePerDay());
			preparedStatement.setBoolean(9, entity.isAvailable());
			preparedStatement.setString(10, entity.getImage());
			preparedStatement.setInt(11, entity.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return 0;
	}

	@Override
	public void delete(int id) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	@Override
	public List<Car> readAll() {

		List<Car> carList = new ArrayList<Car>();
		Car car = null;
		Connection connection = dataBaseConnection.getConnection();
		try (Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(READ_ALL_CARS);
			while (resultSet.next()) {
				car = buildCar(resultSet);
				carList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return carList;
	}

	@Override
	public List<Car> readAllAvailable() {

		List<Car> carList = new ArrayList<Car>();
		Car car = null;
		Connection connection = dataBaseConnection.getConnection();
		try (Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(READ_ALL_AVAILABLE_CARS);
			while (resultSet.next()) {
				car = buildCar(resultSet);
				carList.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return carList;

	}

	@Override
	public void setUnavailableStatus(int id) {
		
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SET_UNAVAILABLE_CAR_STATUS)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}	
	}

}
