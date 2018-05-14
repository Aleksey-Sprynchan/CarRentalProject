package by.htp.sprynchan.car_rental.web.commands.impl.all;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REGISTRATION;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class RegistrationPageCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {	
		return PAGE_REGISTRATION;
	}
}
