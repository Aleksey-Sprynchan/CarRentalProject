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

public class CarDaoImpl implements CarDao {

	private static final String url = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	@Override
	public void create(Car entity) {

		Connection connector = null;

		String sql = "INSERT INTO cars (brand_name, model, type, transmission, doors, "
				+ "passengers, fuel, isAirCondition, isAvailable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		connector = dataBaseConnection.getConnection();
		

		PreparedStatement ps;
		try {
			ps = connector.prepareStatement(sql);
			ps.setString(1, entity.getBrandName());
			ps.setString(2, entity.getModel());
			ps.setString(3, entity.getType());
			ps.setString(4, entity.getTransmission());
			ps.setInt(5, entity.getDoors());
			ps.setInt(6, entity.getPassengers());
			ps.setString(7, entity.getFuel());
			ps.setBoolean(8, entity.isAirCondition());
			ps.setBoolean(9, entity.isAvailable());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

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
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getBoolean("isAvailable"));

				car.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;

	}

	@Override
	public void update(Car entity) {

		String sql = "UPDATE cars SET brand_name=?, model=?, type=?, transmission=?, "
				+ "doors=?, passengers=?, fuel=?, isAirCondition=?, isAvailable=?  WHERE ID=?;";

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
			ps.setBoolean(9, entity.isAvailable());		
			ps.setInt(10, entity.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

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
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getBoolean("isAvailable"));
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
						rs.getString("fuel"), rs.getBoolean("isAirCondition"), rs.getBoolean("isAvailable"));
				car.setId(rs.getInt("id"));
				carList.add(car);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carList;

	}

}
