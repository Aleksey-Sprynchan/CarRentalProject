package by.htp.sprynchan.car_rental.dao.impl;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.sprynchan.car_rental.bean.CarDamageCost;
import by.htp.sprynchan.car_rental.dao.CarDamageCostDao;

public class CarDamageCostDaoDBImpl implements CarDamageCostDao {

	private static final String ADD_CAR_DAMAGE_COST = "INSERT INTO cars_damage_cost (car_id, cracked_windshield_cost, "
			+ "small_dent_cost, broken_headlight_cost, punctured_wheel_cost, large_dent_cost, engine_damage_cost, "
			+ "huge_damage_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String READ_CAR_DAMAGE_COST_BY_CAR_ID = "SELECT id, car_id, cracked_windshield_cost, "
			+ "small_dent_cost, broken_headlight_cost, punctured_wheel_cost, large_dent_cost, engine_damage_cost, "
			+ "huge_damage_cost FROM cars_damage_cost WHERE car_id = ?;";

	private static final String UPDATE_CAR_DAMAGE_COST_BY_CAR_ID = "UPDATE cars_damage_cost SET cracked_windshield_cost = ?, "
			+ "small_dent_cost = ?, broken_headlight_cost = ?, punctured_wheel_cost = ?, large_dent_cost = ?, "
			+ "engine_damage_cost = ?, huge_damage_cost = ? WHERE car_id = ?;";

	private static final String DELETE_CAR_DAMAGE_COST_BY_ID = "DELETE FROM cars_damage_cost WHERE id = ?;";
	
	

	public CarDamageCostDaoDBImpl() {}

	@Override
	public int create(CarDamageCost entity) {

		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_CAR_DAMAGE_COST,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, entity.getCarId());
			preparedStatement.setInt(2, entity.getCrackedWindshieldCost());
			preparedStatement.setInt(3, entity.getSmallDentCost());
			preparedStatement.setInt(4, entity.getBrokenHeadlightCost());
			preparedStatement.setInt(5, entity.getPuncturedWheelCost());
			preparedStatement.setInt(6, entity.getLargeDentCost());
			preparedStatement.setInt(7, entity.getEngineDamageCost());
			preparedStatement.setInt(8, entity.getHugeDamageCost());
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
	public CarDamageCost read(int carId) {

		CarDamageCost carDamageCost = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_CAR_DAMAGE_COST_BY_CAR_ID)) {
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				carDamageCost = buildCarDamageCost(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return carDamageCost;
	}

	@Override
	public int update(CarDamageCost entity) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_DAMAGE_COST_BY_CAR_ID)) {

			preparedStatement.setInt(1, entity.getCrackedWindshieldCost());
			preparedStatement.setInt(2, entity.getSmallDentCost());
			preparedStatement.setInt(3, entity.getBrokenHeadlightCost());
			preparedStatement.setInt(4, entity.getPuncturedWheelCost());
			preparedStatement.setInt(5, entity.getLargeDentCost());
			preparedStatement.setInt(6, entity.getEngineDamageCost());
			preparedStatement.setInt(7, entity.getHugeDamageCost());
			preparedStatement.setInt(8, entity.getCarId());
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
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_DAMAGE_COST_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	private CarDamageCost buildCarDamageCost(ResultSet resultSet) throws SQLException {

		CarDamageCost carDamageCost = new CarDamageCost();
		carDamageCost.setId(resultSet.getInt(CARDAMCOST_COLUMN_ID));
		carDamageCost.setCarId(resultSet.getInt(CARDAMCOST_COLUMN_CAR_ID));
		carDamageCost.setCrackedWindshieldCost(resultSet.getInt(CARDAMCOST_COLUMN_CRACKEDWS_C));
		carDamageCost.setSmallDentCost(resultSet.getInt(CARDAMCOST_COLUMN_SMALL_DENT_C));
		carDamageCost.setBrokenHeadlightCost(resultSet.getInt(CARDAMCOST_COLUMN_BROKENHL_C));
		carDamageCost.setPuncturedWheelCost(resultSet.getInt(CARDAMCOST_COLUMN_PUNCTW_C));
		carDamageCost.setLargeDentCost(resultSet.getInt(CARDAMCOST_COLUMN_LARGE_DENT_C));
		carDamageCost.setEngineDamageCost(resultSet.getInt(CARDAMCOST_COLUMN_ENDAMAGE_C));
		carDamageCost.setHugeDamageCost(resultSet.getInt(CARDAMCOST_COLUMN_HUGEDAM_C));
		return carDamageCost;
	}

}
