package by.htp.sprynchan.car_rental.web.controller;

import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_ADMIN_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_USER_URL;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.REDIRECT_GUEST_URL;
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

	private static final Logger LOGGER = LogManager.getLogger();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BaseCommand requestCommand = CommandFactory.defineCommand(request);
		String path = null;
		try {
			path = requestCommand.executeCommand(request);
			if (path.equals(REDIRECT_ADMIN_URL)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_ADMIN_URL);
			} else if (path.equals(REDIRECT_USER_URL)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_USER_URL);
			} else if (path.equals(REDIRECT_GUEST_URL)) {
				response.sendRedirect(request.getContextPath() + REDIRECT_GUEST_URL);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}
		} catch (CommandException e) {
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
			LOGGER.error(e.getMessage(), e);
		}
	}

}
