package by.htp.sprynchan.car_rental.service.util;

import by.htp.sprynchan.car_rental.service.exception.ServiceException;

/**
 * Class that provides not null validation for
 * input parameters in service layer
 * 
 * @author Aleksey Sprynchan
 *      
 */
public final class ServiceInputParamNullValidator {

	private static final String ERROR_EMPTY_PARAMETER = "Empty parameter recieved";

	private ServiceInputParamNullValidator() {
		throw new IllegalStateException("Utility class");
	}

	public static void validateInputParamNotNull(Object... object) throws ServiceException {
		for (Object o : object) {
			if (o == null) {
				throw new ServiceException(ERROR_EMPTY_PARAMETER);
			}
		}

	}

}
