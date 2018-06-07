package by.htp.sprynchan.car_rental.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.sprynchan.car_rental.web.exception.ValidateNullRequestParamException;

public final class HttpRequestParamValidator {

	private HttpRequestParamValidator() {
		throw new IllegalStateException("Utility class");
	}

	private static final String ERROR_REQUEST_PARAMETER_IS_NULL = "Request parameter is not initialized!";

	private static final String BRANDNAME_MODEL_REGEX = "([\\wА-Яа-яЁё]{1,50})([\\-\\s]?)([\\wА-Яа-яЁё]{0,50})";

	private static final String ONLY_LETTERS_REGEX = "[A-Za-zА-Яа-яЁё]{1,50}";

	private static final String PASSENGERS_REGEX = "([1-9])([0-9]?)";

	private static final String PRICE_PER_DAY_REGEX = "([1-9])([0-9]{0,2})";

	private static final String IMAGE_LINK_REGEX = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

	private static final String POSITIVE_NUMBER_REGEX = "([1-9])([0-9]*)";

	private static final String DAMAGE_NAMES_REGEX = ".+";

	private static final String DAMAGE_COSTS_REGEX = "([1-9])([0-9]{0,3})";

	private static final String LOGIN_REGEX = "[0-9a-zA-Z_@$]{5,}"; /* мин 5 символов из тех что в скобках */

	private static final String PASS_REGEX = "(?=.*[a-zA-z])(?=.*[0-9]).{5,}"; /*
																				 * минимум 5 символов, мин одна лат
																				 * буква и одно число и любые другие
																				 * символы
																				 */

	private static final String NAME_REGEX = "^[A-ZА-ЯЁ][A-Za-zА-Яа-яЁё]{1,50}"; /*
																					 * латин и кирил мин 2 буквы, первая
																					 * заглавная
																					 */

	private static final String SURNAME_REGEX = "(^[A-ZА-ЯЁ][A-Za-zА-Яа-яЁё]{0,50})([\\-]?)([A-Za-zА-Яа-яЁё]{0,50})"; /*
																														 * возможно
																														 * двойная
																														 * фамилия
																														 * через
																														 * дефис
																														 * (первая
																														 * буква
																														 * заглвная)
																														 */

	private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"; /*
																							 * Pattern.CASE_INSENSITIVE
																							 */

	private static final String DATE_REGEX = "((19|20)\\d\\d)\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])"; /*
																												 * дата
																												 * в
																												 * формате
																												 * YYYY-
																												 * MM-DD
																												 */

	private static final String PASSPORT_NUMB_REGEX = "[0-9a-zA-Z]+"; /* мин 5 символов из тех что в скобках */

	private static final String DEPOSIT_AMOUNT_REGEX = "[1-9][0-9]{0,2}"; /* число от 1 до 999 */

	public static void validateParamNotNull(String s) throws ValidateNullRequestParamException {
		if (s == null) {
			throw new ValidateNullRequestParamException(ERROR_REQUEST_PARAMETER_IS_NULL);
		}
	}

	public static boolean validateBrandNameOrModel(String branNameOrModel) throws ValidateNullRequestParamException {
		validateParamNotNull(branNameOrModel);
		return matchToRegex(branNameOrModel, BRANDNAME_MODEL_REGEX);
	}

	public static boolean validateType(String type) throws ValidateNullRequestParamException {
		validateParamNotNull(type);
		return matchToRegex(type, ONLY_LETTERS_REGEX);
	}

	public static boolean validateTransmission(String transmission) throws ValidateNullRequestParamException {
		validateParamNotNull(transmission);
		return matchToRegex(transmission, ONLY_LETTERS_REGEX);
	}

	public static boolean validatePassengers(String passengers) throws ValidateNullRequestParamException {
		validateParamNotNull(passengers);
		return matchToRegex(passengers, PASSENGERS_REGEX);
	}

	public static boolean validateFuel(String fuel) throws ValidateNullRequestParamException {
		validateParamNotNull(fuel);
		return matchToRegex(fuel, ONLY_LETTERS_REGEX);
	}

	public static boolean validatePricePerDay(String pricePerDay) throws ValidateNullRequestParamException {
		validateParamNotNull(pricePerDay);
		return matchToRegex(pricePerDay, PRICE_PER_DAY_REGEX);
	}

	public static boolean validateImageLink(String imageLink) throws ValidateNullRequestParamException {
		validateParamNotNull(imageLink);
		return matchToRegex(imageLink, IMAGE_LINK_REGEX);
	}

	public static boolean validatePositiveInt(String value) throws ValidateNullRequestParamException {
		validateParamNotNull(value);
		if (matchToRegex(value, POSITIVE_NUMBER_REGEX)) {
			try {
				Integer.parseInt(value);
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateDamageNames(String[] damageNames) throws ValidateNullRequestParamException {
		if (damageNames != null) {
			for (int i = 0; i < damageNames.length; i++) {
				validateParamNotNull(damageNames[i]);
				if (!matchToRegex(damageNames[i].trim(), DAMAGE_NAMES_REGEX)) {
					return false;
				}
			}
			return true;
		} else {
			throw new ValidateNullRequestParamException(ERROR_REQUEST_PARAMETER_IS_NULL);
		}

	}

	public static boolean validateDamageCosts(String[] damageCosts) throws ValidateNullRequestParamException {
		if (damageCosts != null) {
			for (int i = 0; i < damageCosts.length; i++) {
				validateParamNotNull(damageCosts[i]);
				if (!matchToRegex(damageCosts[i].trim(), DAMAGE_COSTS_REGEX)) {
					return false;
				}
			}
			return true;
		} else {
			throw new ValidateNullRequestParamException(ERROR_REQUEST_PARAMETER_IS_NULL);
		}

	}

	public static boolean validateLogin(String login) throws ValidateNullRequestParamException {
		validateParamNotNull(login);
		return matchToRegex(login, LOGIN_REGEX);
	}

	public static boolean validatePassword(String pass) throws ValidateNullRequestParamException {
		validateParamNotNull(pass);
		return matchToRegex(pass, PASS_REGEX);
	}

	public static boolean validateName(String name) throws ValidateNullRequestParamException {
		validateParamNotNull(name);
		return matchToRegex(name, NAME_REGEX);
	}

	public static boolean validateSurname(String surname) throws ValidateNullRequestParamException {
		validateParamNotNull(surname);
		return matchToRegex(surname, SURNAME_REGEX);
	}

	public static boolean validateEmail(String email) throws ValidateNullRequestParamException {
		validateParamNotNull(email);
		return matchToRegexCaseIns(email, EMAIL_REGEX);
	}

	public static boolean validateDate(String date) throws ValidateNullRequestParamException {
		validateParamNotNull(date);
		return matchToRegex(date, DATE_REGEX);
	}

	public static boolean validatePassportNumb(String date) throws ValidateNullRequestParamException {
		validateParamNotNull(date);
		return matchToRegex(date, PASSPORT_NUMB_REGEX);
	}

	public static boolean validateDepositAmount(String depositAmmount) throws ValidateNullRequestParamException {
		validateParamNotNull(depositAmmount);
		return matchToRegex(depositAmmount, DEPOSIT_AMOUNT_REGEX);
	}

	private static boolean matchToRegexCaseIns(String input, String regex) {
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		return m.matches();
	}

	private static boolean matchToRegex(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.matches();
	}

}
