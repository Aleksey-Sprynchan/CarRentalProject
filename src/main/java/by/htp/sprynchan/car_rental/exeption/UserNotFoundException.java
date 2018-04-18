package by.htp.sprynchan.car_rental.exeption;

import by.htp.sprynchan.car_rental.web.util.CommandEnum;

public class UserNotFoundException extends BaseException {

	private static final long serialVersionUID = -2918714739087557076L;
	
	public UserNotFoundException() {
		super(CommandEnum.AUTHORIZATION, "Incorrect login or password.");
	}

}
