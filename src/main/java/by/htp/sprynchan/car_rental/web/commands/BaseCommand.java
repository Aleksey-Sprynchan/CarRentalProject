package by.htp.sprynchan.car_rental.web.commands;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.exception.CommandException;

public interface BaseCommand {
	
	 String executeCommand (HttpServletRequest request) throws CommandException;	 
}
