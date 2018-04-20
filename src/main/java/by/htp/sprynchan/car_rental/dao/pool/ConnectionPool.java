package by.htp.sprynchan.car_rental.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

	private static volatile ConnectionPool instance;

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "ROOT";
	private static final int MAX_CONNECTION_COUNT = 10;
	private static final int MIN_CONNECTION_COUNT = 5;

	private volatile int currentConnectionNumber = MIN_CONNECTION_COUNT;

	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(MAX_CONNECTION_COUNT, true);

	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}

	private ConnectionPool() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < MIN_CONNECTION_COUNT; i++) {
			try {
				pool.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {

		Connection connection = null;
		try {
			if (pool.isEmpty() && currentConnectionNumber < MAX_CONNECTION_COUNT) {
				openAdditionalConnection();
			}
			connection = pool.take();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {

			if (currentConnectionNumber > MIN_CONNECTION_COUNT) {
				currentConnectionNumber--;
			}
			try {
				pool.put(connection);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void openAdditionalConnection() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		try {
			pool.add(DriverManager.getConnection(URL, LOGIN, PASSWORD));
			currentConnectionNumber++;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
