package by.htp.sprynchan.car_rental.web.commands.impl.user;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_DEPOSIT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class DepositPageCommandImpl implements BaseCommand {

	public DepositPageCommandImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		return PAGE_DEPOSIT;
	}

}
