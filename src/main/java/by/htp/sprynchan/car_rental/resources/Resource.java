package by.htp.sprynchan.car_rental.resources;

import static by.htp.sprynchan.car_rental.web.util.WebConstantDeclaration.*;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
/**
 * This class provides an access to properties file
 *
 * @author Aleksey Sprynchan
 */
public class Resource {
	
	/**
	 * This is path to properties file
	 */
	private static final String RESOURCE_PATH = "Resource";

	/**
	 * Resource bundles contain needed objects
	 */
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_PATH);

	/**
     * This method return property by key
     *
     * @param key a name of property
     * @return value of property
     */
	public static String getStr(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * This method return property by key
	 * and localization
	 * 
	 * @param key
	 * @param HttpServletRequest request
	 * @return value of property
	 */
	public static String getStrLocale(String key, HttpServletRequest request) {
		String languageTag = (String) request.getSession().getAttribute(REQUEST_PARAM_LOCALE);
		Locale locale = Locale.forLanguageTag(languageTag);
		ResourceBundle resourceBundleLocale = ResourceBundle.getBundle(RESOURCE_PATH, locale);
		return resourceBundleLocale.getString(key);
	}
}
