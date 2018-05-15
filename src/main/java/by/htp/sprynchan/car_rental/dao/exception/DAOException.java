package by.htp.sprynchan.car_rental.dao.exception;

import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public class DAOException extends ServiceException  {

	private static final long serialVersionUID = -2600278547668796167L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
}
