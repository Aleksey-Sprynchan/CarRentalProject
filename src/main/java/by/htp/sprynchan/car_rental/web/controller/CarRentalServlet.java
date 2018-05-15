package by.htp.sprynchan.car_rental.web.controller;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.exception.CommandException;
import by.htp.sprynchan.car_rental.web.util.CommandFactory;

public class CarRentalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAMETER_MESSAGE = "message";
	
	private static final Logger LOGGER = LogManager.getLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost");
		process(request, response);

	}	

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseCommand requestCommand = CommandFactory.defineCommand(request);
		String path = null;
		
		try {
			path = requestCommand.executeCommand(request);

		} catch (CommandException e) {
			path = PAGE_ERROR;
			request.setAttribute(PARAMETER_MESSAGE, e.getMessage());
			LOGGER.error(e.getMessage(), e);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	
	}
	

}
