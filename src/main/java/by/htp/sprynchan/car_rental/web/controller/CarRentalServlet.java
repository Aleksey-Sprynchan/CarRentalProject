package by.htp.sprynchan.car_rental.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.sprynchan.car_rental.exeption.BaseException;
import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.util.CommandFactory;

public class CarRentalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAMETER_MESSAGE = "message";
	
	private static final Logger logger = LogManager.getLogger();

	@Override
	public void init() throws ServletException {
		System.out.println("init servlet");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

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
			path = requestCommand.executeCommand(request, response);
			
			request.setAttribute("user_type", request.getSession().getAttribute("user_type"));
		} catch (BaseException e) {
			path = "/jsp/error.jsp";
			request.setAttribute(PARAMETER_MESSAGE, e.getMessage());
			logger.error(e.getMessage());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	
	}
	

}
