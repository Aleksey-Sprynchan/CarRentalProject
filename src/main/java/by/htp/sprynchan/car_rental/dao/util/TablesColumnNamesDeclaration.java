package by.htp.sprynchan.car_rental.dao.util;

/**
 * Utility class where declared all columns names 
 * database tables
 * 
 * @author Aleksey Sprynchan
 */
public final class TablesColumnNamesDeclaration {

	private TablesColumnNamesDeclaration() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String CARS_COLUMN_ID = "id";
	public static final String CARS_COLUMN_BRAND_NAME = "brand_name";
	public static final String CARS_COLUMN_MODEL = "model";
	public static final String CARS_COLUMN_TYPE = "type";
	public static final String CARS_COLUMN_TRANSMISSION = "transmission";
	public static final String CARS_COLUMN_PASSENGERS = "passengers";
	public static final String CARS_COLUMN_FUEL = "fuel";
	public static final String CARS_COLUMN_IS_AIR_CONDITION = "is_air_condition";
	public static final String CARS_COLUMN_PRICE_PER_DAY = "price_per_day";
	public static final String CARS_COLUMN_IS_AVAILABLE = "is_available";
	public static final String CARS_COLUMN_IMAGE = "image";
	
	public static final String ORDERS_COLUMN_ID = "id";
	public static final String ORDERS_COLUMN_STATUS = "status";
	public static final String ORDERS_COLUMN_ORDER_DATE = "order_date";
	public static final String ORDERS_COLUMN_USER_ID = "user_id";
	public static final String ORDERS_COLUMN_CAR_ID = "car_id";
	public static final String ORDERS_COLUMN_START_DATE = "start_date";
	public static final String ORDERS_COLUMN_END_DATE = "end_date";
	public static final String ORDERS_COLUMN_CUSTOMER_ID = "customer_id";
	public static final String ORDERS_COLUMN_TOTAL_PRICE = "total_price";
	public static final String ORDERS_COLUMN_IS_INSURANCE = "insurance";
	public static final String ORDERS_COLUMN_IS_DAMAGED = "is_damaged";
	public static final String ORDERS_COLUMN_DAMAGE_AMOUNT = "damage_amount";
	public static final String ORDERS_COLUMN_REJECTION_REASON = "rejection_reason";
	
	public static final String CUSTPERSDATA_COLUMN_ID = "id";
	public static final String CUSTPERSDATA_COLUMN_NAME = "name";
	public static final String CUSTPERSDATA_COLUMN_SURNAME = "surname";
	public static final String CUSTPERSDATA_COLUMN_PASSPORT_NUMB = "passport_numb";
	public static final String CUSTPERSDATA_COLUMN_DATE_OF_BIRTH = "date_of_birth";
	public static final String CUSTPERSDATA_COLUMN_DRIVING_EXP = "driving_exp";
	
	public static final String USERS_COLUMN_ID = "id";
	public static final String USERS_COLUMN_LOGIN = "login";
	public static final String USERS_COLUMN_PASSWORD = "password";
	public static final String USERS_COLUMN_NAME = "name";
	public static final String USERS_COLUMN_SURNAME = "surname";
	public static final String USERS_COLUMN_EMAIL = "email";
	public static final String USERS_COLUMN_BALANCE = "balance";
	public static final String USERS_COLUMN_IS_ADMIN = "is_admin";
	
	public static final String DAMAGES_COLUMN_ID = "id";
	public static final String DAMAGES_COLUMN_ORDER_ID = "order_id";
	public static final String DAMAGES_COLUMN_CAR_ID = "car_id";
	public static final String DAMAGES_COLUMN_DAMAGE_NAME = "damage_name";
	public static final String DAMAGES_COLUMN_DAMAGE_COST = "damage_cost";
		

}
