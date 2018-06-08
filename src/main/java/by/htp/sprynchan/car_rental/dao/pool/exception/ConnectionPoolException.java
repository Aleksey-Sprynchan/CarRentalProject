package by.htp.sprynchan.car_rental.dao.pool.exception;

import by.htp.sprynchan.car_rental.dao.exception.DAOException;

/**
 * @author Aleksey Sprynchan
 * @see by.htp.sprynchan.car_rental.dao.exception.DAOException
 * <p/>
 * <code>ConnectionPoolException</code>
 * <p/>
 * Exception class created specifically to describe the exceptional
 * situation arises in the Connection pool layer application.
 */
public class ConnectionPoolException extends DAOException {

	private static final long serialVersionUID = -3172613280076668173L;

	public ConnectionPoolException() {
	}

	public ConnectionPoolException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionPoolException(String message) {
		super(message);
	}

	public ConnectionPoolException(Throwable cause) {
		super(cause);
	}

}
