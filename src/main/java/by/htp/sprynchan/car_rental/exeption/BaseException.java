package by.htp.sprynchan.car_rental.exeption;

import by.htp.sprynchan.car_rental.web.util.CommandEnum;

public class BaseException extends Exception{

	private static final long serialVersionUID = -8608145688890704917L;
	private String actionName;

	public String getActionName() {
		return actionName;
	}

	public BaseException(CommandEnum command) {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(CommandEnum command, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BaseException(CommandEnum command, String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(CommandEnum command, String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseException(CommandEnum command,Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
