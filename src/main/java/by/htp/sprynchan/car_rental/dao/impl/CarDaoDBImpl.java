package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Car;
import by.htp.sprynchan.car_rental.dao.CarDao;

public class CarDaoDBImpl implements CarDao {

	private static final String url = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	@Override
	public int create(Car entity) {
		 // TODO transaction with damage_costs threw car_id
		
		
		
		Connection connection = null;

		String sql = "INSERT INTO cars (brand_name, model, type, transmission, doors, "
				+ "passengers, fuel, isAirCondition, price_per_day, isAvailable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		connection = dataBaseConnection.getConnection();
		
		int id = 0;
		
		try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, entity.getBrandName());
			ps.setString(2, entity.getModel());
			ps.setString(3, entity.getType());
			ps.setString(4, entity.getTransmission());
			ps.setInt(5, entity.getDoors());
			ps.setInt(6, entity.getPassengers());
			ps.setString(7, entity.getFuel());
			ps.setBoolean(8, entity.isAirCondition());
			ps.setInt(9, entity.getPricePerDay());
			ps.setBoolean(10, entity.isAvailable());
			ps.executeUpdate();
			
			ResultSet resultSet = ps.getGeneratedKeys();
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

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			// TODO prepared
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE id=" + String.valueOf(id));

			if (rs.next()) {
				car = new Car(rs.getString("brand_name"), rs.getString("model"), rs.getString("type"),
						rs.getString("transmission"), rs.getInt("doors"), rs.getInt("passengers"), 
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getInt("price_per_day"), rs.getBoolean("isAvailable"));

				car.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;

	}

	@Override
	public int update(Car entity) {

		String sql = "UPDATE cars SET brand_name=?, model=?, type=?, transmission=?, "
				+ "doors=?, passengers=?, fuel=?, isAirCondition=?, price_per_day=?, isAvailable=?  WHERE ID=?;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setString(1, entity.getBrandName());
			ps.setString(2, entity.getModel());
			ps.setString(3, entity.getType());
			ps.setString(4, entity.getTransmission());
			ps.setInt(5, entity.getDoors());
			ps.setInt(6, entity.getPassengers());
			ps.setString(7, entity.getFuel());
			ps.setBoolean(8, entity.isAirCondition());
			ps.setInt(9, entity.getPricePerDay());
			ps.setBoolean(10, entity.isAvailable());		
			ps.setInt(11, entity.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM cars WHERE ID=?;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement statement = cn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Car> readAll() {

		List<Car> carList = new ArrayList<Car>();
		Car car = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cars");

			while (rs.next()) {
				car = new Car(rs.getString("brand_name"), rs.getString("model"), rs.getString("type"),
						rs.getString("transmission"), rs.getInt("doors"), rs.getInt("passengers"), 
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getInt("price_per_day"), rs.getBoolean("isAvailable"));
				car.setId(rs.getInt("id"));
				carList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carList;
	}

	@Override
	public List<Car> readAllAvailable() {

		List<Car> carList = new ArrayList<Car>();
		Car car = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE isAvailable = 1;");

			while (rs.next()) {
				car = new Car(rs.getString("brand_name"), rs.getString("model"), rs.getString("type"),
						rs.getString("transmission"), rs.getInt("doors"), rs.getInt("passengers"), 
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getInt("price_per_day"), rs.getBoolean("isAvailable"));
				car.setId(rs.getInt("id"));
				carList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carList;

	}

}
