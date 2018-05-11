package by.htp.sprynchan.car_rental.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

	private static volatile ConnectionPool instance;

	private static final String DB_CONNECT_PROPERTY = "db_config";

	private static final String RESOURCE_DRIVER_NAME = "db.driver.name";
	private static final String RESOURCE_URL = "db.url";
	private static final String RESOURCE_LOGIN = "db.login";
	private static final String RESOURCE_PASS = "db.pass";
	private static final int MAX_CONNECTION_COUNT = 10;
	private static final int MIN_CONNECTION_COUNT = 5;
	private static String url;
	private static String login;
	private static String pass;
	private static String driverName;

	static {
		ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
		url = rb.getString(RESOURCE_URL);
		login = rb.getString(RESOURCE_LOGIN);
		pass = rb.getString(RESOURCE_PASS);
		driverName = rb.getString(RESOURCE_DRIVER_NAME);
	}

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
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < MIN_CONNECTION_COUNT; i++) {
			try {
				pool.add(DriverManager.getConnection(url, login, pass));
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
			Class.forName(driverName);
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		try {
			pool.add(DriverManager.getConnection(url, login, pass));
			currentConnectionNumber++;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
