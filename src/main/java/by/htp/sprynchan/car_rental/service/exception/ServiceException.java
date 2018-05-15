package by.htp.sprynchan.car_rental.service.exception;

import by.htp.sprynchan.car_rental.web.exception.CommandException;

public class ServiceException extends CommandException {

	private static final long serialVersionUID = -9046743623305322740L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
