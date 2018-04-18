package by.htp.sprynchan.car_rental.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String code;
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

//		System.out.println("INIT FILTER 222222222");
		code = filterConfig.getInitParameter("encoding");
//		System.out.println("init" + code);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
//		System.out.println("FILTER 222222222222");
		
//		final HttpServletRequest req = (HttpServletRequest) request;
		
		String codeRequest = request.getCharacterEncoding();

		if (code != null && !code.equalsIgnoreCase(codeRequest)) {
			request.setCharacterEncoding(code);
			response.setCharacterEncoding(code);
		}
		
//		System.out.println("!!!!!!!" + request.getCharacterEncoding());
		
		chain.doFilter(request, response);

	}

	

	@Override
	public void destroy() {
//		System.out.println("DESTROY FILTER 222222222222");
	}

}
