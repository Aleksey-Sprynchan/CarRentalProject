package by.htp.sprynchan.car_rental.dao.impl;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.DamageHistory;
import by.htp.sprynchan.car_rental.dao.DamageHistoryDao;

public class DamageHistoryDaoDBImpl implements DamageHistoryDao {
	
	private static final String ADD_DAMAGE_HIST = "INSERT INTO damage_history (order_id, car_id, cracked_windshield, "
			+ "small_dent, broken_headlight, punctured_wheel, large_dent, engine_damage, huge_damage) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String READ_DAMAGE_HIST_BY_ORDER_ID = "SELECT id, order_id, car_id, cracked_windshield, "
			+ "small_dent, broken_headlight, punctured_wheel, large_dent, engine_damage, huge_damage "
			+ "FROM damage_history WHERE order_id = ?;";

	private static final String UPDATE_DAMAGE_HIST_BY_ID = "UPDATE damage_history SET order_id = ?, car_id = ?, "
			+ "cracked_windshield = ?, small_dent = ?, broken_headlight = ?, punctured_wheel = ?, large_dent = ?, "
			+ "engine_damage = ?, huge_damage = ? WHERE id = ?;";

	private static final String DELETE_DAMAGE_HIST_BY_ID = "DELETE FROM damage_history WHERE id = ?;";
	
	private static final String READ_ALL_CARDAMHIST_BY_CAR_ID = "SELECT id, order_id, car_id, cracked_windshield, "
			+ "small_dent, broken_headlight, punctured_wheel, large_dent, engine_damage, huge_damage "
			+ "FROM damage_history WHERE car_id = ?;";

	public DamageHistoryDaoDBImpl() {}

	@Override
	public int create(DamageHistory entity) {
		
		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_DAMAGE_HIST,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, entity.getOrderId());
			preparedStatement.setInt(2, entity.getCarId());
			preparedStatement.setBoolean(3, entity.isCrackedWindshield());
			preparedStatement.setBoolean(4, entity.isSmallDent());
			preparedStatement.setBoolean(5, entity.isBrokenHeadlight());
			preparedStatement.setBoolean(6, entity.isPuncturedWheel());
			preparedStatement.setBoolean(7, entity.isLargeDent());
			preparedStatement.setBoolean(8, entity.isEngineDamage());
			preparedStatement.setBoolean(9, entity.isHugeDamage());
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
	public DamageHistory read(int orderId) {

		DamageHistory damageHistory = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_DAMAGE_HIST_BY_ORDER_ID)) {
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				damageHistory = buildDamageHistory(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return damageHistory;
	}

	@Override
	public int update(DamageHistory entity) {
		
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DAMAGE_HIST_BY_ID)) {
			preparedStatement.setInt(1, entity.getOrderId());
			preparedStatement.setInt(2, entity.getCarId());
			preparedStatement.setBoolean(3, entity.isCrackedWindshield());
			preparedStatement.setBoolean(4, entity.isSmallDent());
			preparedStatement.setBoolean(5, entity.isBrokenHeadlight());
			preparedStatement.setBoolean(6, entity.isPuncturedWheel());
			preparedStatement.setBoolean(7, entity.isLargeDent());
			preparedStatement.setBoolean(8, entity.isEngineDamage());
			preparedStatement.setBoolean(9, entity.isHugeDamage());
			preparedStatement.setInt(10, entity.getId());
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
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DAMAGE_HIST_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}

	}

	@Override
	public List<DamageHistory> readAllCarDamHist(int carId) {

		List<DamageHistory> carDamHistList = new ArrayList<>();
		DamageHistory damageHistory = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_CARDAMHIST_BY_CAR_ID)) {

			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				damageHistory = buildDamageHistory(resultSet);;
				carDamHistList.add(damageHistory);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return carDamHistList;
	}
	
	
	private DamageHistory buildDamageHistory(ResultSet resultSet) throws SQLException {

		DamageHistory damageHistory = new DamageHistory();
		damageHistory.setId(resultSet.getInt(DAMHIST_COLUMN_ID));
		damageHistory.setOrderId(resultSet.getInt(DAMHIST_COLUMN_ORDER_ID));
		damageHistory.setCarId(resultSet.getInt(DAMHIST_COLUMN_CAR_ID));
		damageHistory.setCrackedWindshield(resultSet.getBoolean(DAMHIST_COLUMN_CRACKEDWS));
		damageHistory.setSmallDent(resultSet.getBoolean(DAMHIST_COLUMN_SMALL_DENT));
		damageHistory.setBrokenHeadlight(resultSet.getBoolean(DAMHIST_COLUMN_BROKENHL));
		damageHistory.setPuncturedWheel(resultSet.getBoolean(DAMHIST_COLUMN_PUNCTW));
		damageHistory.setLargeDent(resultSet.getBoolean(DAMHIST_COLUMN_LARGE_DENT));
		damageHistory.setEngineDamage(resultSet.getBoolean(DAMHIST_COLUMN_ENDAMAGE));
		damageHistory.setHugeDamage(resultSet.getBoolean(DAMHIST_COLUMN_HUGEDAM));
		return damageHistory;
	}

}
