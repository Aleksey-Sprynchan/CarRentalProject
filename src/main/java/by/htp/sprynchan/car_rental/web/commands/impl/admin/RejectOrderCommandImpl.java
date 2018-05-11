package by.htp.sprynchan.car_rental.web.commands.impl.admin;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_REJECTION_FORM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;

public class RejectOrderCommandImpl implements BaseCommand {

	public static final String PARAMETER_ORDER_ID = "order_id";

	@Override
	public String executeCommand(HttpServletRequest request, HttpServletResponse response) throws BaseException {
		
		int orderId = Integer.parseInt(request.getParameter(PARAMETER_ORDER_ID));		
		request.setAttribute(PARAMETER_ORDER_ID, orderId);	
		return PAGE_REJECTION_FORM;
	}
	
}
