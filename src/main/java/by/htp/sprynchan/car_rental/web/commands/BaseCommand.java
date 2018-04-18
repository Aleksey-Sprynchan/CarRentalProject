package by.htp.sprynchan.car_rental.web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.sprynchan.car_rental.exeption.BaseException;


public interface BaseCommand {
	
	 String executeCommand (HttpServletRequest request, HttpServletResponse response) throws BaseException;
	 
}
