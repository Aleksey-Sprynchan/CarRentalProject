package by.htp.sprynchan.car_rental.web.util;

public final class WebConstantDeclaration {
	
	private WebConstantDeclaration() {
		throw new IllegalStateException("Utility class");
	}	
	
	public static final String REQUEST_PARAM_CAR = "car";
	public static final String REQUEST_PARAM_CAR_ID = "car_id";
	public static final String REQUEST_PARAM_BRAND_NAME = "brand_name";
	public static final String REQUEST_PARAM_MODEL = "model";
	public static final String REQUEST_PARAM_TYPE = "type";
	public static final String REQUEST_PARAM_TRANSMISSION= "transmission";
	public static final String REQUEST_PARAM_PASSENGERS= "passengers";
	public static final String REQUEST_PARAM_FUEL= "fuel";
	public static final String REQUEST_PARAM_AIR_CONDITION= "air_condition";
	public static final String REQUEST_PARAM_PRICE_PER_DAY= "price_per_day";
	public static final String REQUEST_PARAM_IMAGE= "image";
	public static final String REQUEST_PARAM_IS_AVAILABLE = "is_available";	
	public static final String REQUEST_PARAM_CAR_DAMAGE_HISTORY_MAP = "carDamHist_map";
	public static final String REQUEST_PARAM_BRAND_NAMES_LIST = "brand_names_list";
	public static final String REQUEST_PARAM_CAR_LIST = "car_list";
	public static final String REQUEST_PARAM_INACTIVE_CARS = "inactive_cars";
		
	public static final String REQUEST_PARAM_ORDER = "order";
	public static final String REQUEST_PARAM_ORDER_ID = "order_id";
	public static final String REQUEST_PARAM_REJECTION_REASON = "rejection_reason";
	public static final String REQUEST_PARAM_ORDER_STATUS= "order_status";
	public static final String REQUEST_PARAM_ALL_ORDERS= "All orders";
	public static final String REQUEST_PARAM_ORDER_ID_SET = "orderId_set";
	public static final String REQUEST_PARAM_RESERVED_DATES = "reserved_dates";
	public static final String REQUEST_PARAM_ORDER_LIST = "order_list";
	public static final String REQUEST_PARAM_ORDER_STATUS_LIST = "order_status_list";
	public static final String REQUEST_PARAM_ORDER_CAR_MAP = "orderCar_map";
	public static final String REQUEST_PARAM_ORDER_USER_MAP = "orderUser_map";
	public static final String REQUEST_PARAM_START_DATE = "start_date";
	public static final String REQUEST_PARAM_END_DATE = "end_date";
	public static final String REQUEST_PARAM_TOTAL_PRICE = "total_price";
	public static final String REQUEST_PARAM_INSURANCE = "insurance";
	public static final String REQUEST_PARAM_ORDER_DAMAGE_MAP = "orderDam_map";
	public static final String REQUEST_PARAM_ORDER_DAMAGES = "order_damages";
	public static final String REQUEST_PARAM_SELECTED_STATUS = "selected_status";
	
	public static final String REQUEST_PARAM_USER = "user";
	public static final String REQUEST_PARAM_USER_ID = "user_id";
	public static final String REQUEST_PARAM_PASS = "password";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_USER_TYPE = "user_type";
	public static final String REQUEST_PARAM_NAME = "name";
	public static final String REQUEST_PARAM_SURNAME = "surname";
	public static final String REQUEST_PARAM_EMAIL = "email";
	public static final String REQUEST_PARAM_DUPLICATE_MESSAGE = "dup_message";
	public static final String REQUEST_PARAM_OLD_PASS = "old_password";
	public static final String REQUEST_PARAM_NEW_PASS = "new_password";
	public static final String REQUEST_PARAM_CONFIRM_NEW_PASS = "confirm_new_password";
	public static final String REQUEST_PARAM_DEPOSIT_AMOUNT = "deposit_amount";
	public static final String REQUEST_PARAM_USER_LIST = "user_list";
	public static final String REQUEST_PARAM_NEW_USER = "new_user";
	public static final String REQUEST_PARAM_CHANGED_USER = "changed_user";
	public static final String REQUEST_PARAM_CURRENT_USER = "current_user";
	
	public static final String REQUEST_PARAM_DAMAGE = "damage";
	public static final String REQUEST_PARAM_DAMAGE_NAME = "damage_name";
	public static final String REQUEST_PARAM_DAMAGE_COST = "damage_cost";
	
	public static final String REQUEST_PARAM_CPDATA = "cpData";
	public static final String REQUEST_PARAM_CUSTOMER_ID = "customer_id";
	public static final String REQUEST_PARAM_CUSTOMER_NAME = "customer_name";
	public static final String REQUEST_PARAM_CUSTOMER_SURNAME = "customer_surname";
	public static final String REQUEST_PARAM_PASSPORT_NUMB = "passport_numb";
	public static final String REQUEST_PARAM_DATE_OF_BIRTH = "date_of_birth";
	public static final String REQUEST_PARAM_DRIVING_EXP = "driving_exp";
	
	public static final String REQUEST_PARAM_INFO_MESSAGE = "info_message";
	public static final String REQUEST_PARAM_COMMAND = "command";
	public static final String REQUEST_PARAM_LOCALE = "locale";
	public static final String COMMAND_START_PAGE = "start_page";
	
	public static final String REQUEST_PARAM_INVALID_BRAND = "invalid_brand";
	public static final String REQUEST_PARAM_INVALID_MODEL = "invalid_model";
	public static final String REQUEST_PARAM_INVALID_TYPE = "invalid_type";
	public static final String REQUEST_PARAM_INVALID_TRANSMISSION = "invalid_transmission";
	public static final String REQUEST_PARAM_INVALID_PASSENGERS = "invalid_passengers";
	public static final String REQUEST_PARAM_INVALID_FUEL = "invalid_fuel";
	public static final String REQUEST_PARAM_INVALID_PRICE = "invalid_price";
	public static final String REQUEST_PARAM_INVALID_IMAGE_LINK = "invalid_image_link";
	public static final String REQUEST_PARAM_INVALID_ID = "invalid_id";
	public static final String REQUEST_PARAM_EMPTY_DAMAGE_NAME = "empty_damage_name";
	public static final String REQUEST_PARAM_INVALID_COST = "invalid_cost";
	public static final String REQUEST_PARAM_INVALID_LOGIN = "invalid_login";
	public static final String REQUEST_PARAM_INVALID_PASS = "invalid_password";
	public static final String REQUEST_PARAM_INVALID_NAME = "invalid_name";
	public static final String REQUEST_PARAM_INVALID_SURNAME = "invalid_surname";
	public static final String REQUEST_PARAM_INVALID_EMAIL = "invalid_email";
	public static final String REQUEST_PARAM_INVALID_PASSPORT_NUMB = "invalid_passport_numb";
	public static final String REQUEST_PARAM_INVALID_BIRTH_DATE = "invalid_birth_date";
	public static final String REQUEST_PARAM_INVALID_DRIVING_EXP = "invalid_driving_exp";
	public static final String REQUEST_PARAM_INVALID_DATE = "invalid_date";
	public static final String REQUEST_PARAM_INVALID_START_DATE = "invalid_start_date";
	public static final String REQUEST_PARAM_INVALID_END_DATE = "invalid_end_date";
	public static final String REQUEST_PARAM_INVALID_TOTAL_PRICE = "invalid_total_price";
	public static final String REQUEST_PARAM_INVALID_DEPOSIT_AMOUNT = "invalid_deposit_amount";
	
	public static final String SESSION_ATR_SESSION_MESSAGE = "session_message";
	public static final String SESSION_ATR_SESSION_ORDER_ID = "session_order_id";
	public static final String SESSION_ATR_SESSION_PAGE_TYPE = "session_page_type";
	
	public static final String PAGE_TYPE_ADMIN_PROFILE = "admin_profile_page";
	public static final String PAGE_TYPE_ORDER_DETAILS = "order_details_page";
	
	public static final String PAGE_TYPE_USER_PROFILE = "user_profile_page";
	public static final String PAGE_TYPE_ACCOUNT_SETTINGS = "account_settings_page";
	public static final String PAGE_TYPE_CHANGE_PERSONAL_INFO = "change_personal_info_page";
	public static final String PAGE_TYPE_CHANGE_PASS = "change_password_page";
	
	public static final String PARAM_ID = "id";
	
	
	
	
	

}
