package by.htp.sprynchan.car_rental.web.util;

import java.time.LocalDate;

public final class HttpRequestParamFormatter {

	private HttpRequestParamFormatter() {
		throw new IllegalStateException("Utility class");
	}

	public static int formatInt(String param) {
		return Integer.parseInt(param);
	}
	
	public static LocalDate formatLocalDate(String param) {
		return LocalDate.parse(param);
	}
	
	public static boolean formatBoolean(String param) {
		return Boolean.parseBoolean(param);
	}
}

