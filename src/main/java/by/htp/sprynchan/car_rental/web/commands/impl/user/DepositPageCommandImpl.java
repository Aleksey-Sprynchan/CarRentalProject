package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_DEPOSIT;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class DepositPageCommandImpl implements BaseCommand {

	@Override
	public String executeCommand(HttpServletRequest request) throws BaseException {
		return PAGE_DEPOSIT;
	}
}
