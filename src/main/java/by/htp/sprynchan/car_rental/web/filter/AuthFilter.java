package by.htp.sprynchan.car_rental.web.filter;

import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;
import static by.htp.sprynchan.car_rental.web.util.PagePathConstantPool.PAGE_ERROR;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.web.util.CommandEnum;
import by.htp.sprynchan.car_rental.web.util.UserTypeEnum;

public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpSession session = req.getSession(true);

		User currentUser = (User) session.getAttribute(REQUEST_PARAM_USER);
		String inputCommand = request.getParameter(REQUEST_PARAM_COMMAND);
		CommandEnum command = null;
		if (inputCommand != null && !inputCommand.isEmpty()) {
			command = CommandEnum.valueOfOrDefault(inputCommand.toUpperCase());

			if (currentUser != null) {
				if (currentUser.isAdmin() && command.getUserType() == UserTypeEnum.ADMIN) {
					chain.doFilter(request, response);
				} else if (!currentUser.isAdmin() && command.getUserType() == UserTypeEnum.USER) {
					chain.doFilter(request, response);
				} else if (command.getUserType() == UserTypeEnum.ALL) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
				}
			} else {
				if (command.getUserType() == UserTypeEnum.ALL) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
				}
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
