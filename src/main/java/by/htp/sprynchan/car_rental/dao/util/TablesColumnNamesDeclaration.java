package by.htp.sprynchan.car_rental.dao.util;

public final class TablesColumnNamesDeclaration {

	private TablesColumnNamesDeclaration() {}
	
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
	public static final String ORDERS_COLUMN_IS_DAMAGED = "isDamaged";
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
	public static final String USERS_COLUMN_IS_ADMIN = "isAdmin";
	
	public static final String CARDAMCOST_COLUMN_ID = "id";
	public static final String CARDAMCOST_COLUMN_CAR_ID = "car_id";
	public static final String CARDAMCOST_COLUMN_CRACKEDWS_C = "cracked_windshield_cost";
	public static final String CARDAMCOST_COLUMN_SMALL_DENT_C = "small_dent_cost";
	public static final String CARDAMCOST_COLUMN_BROKENHL_C = "broken_headlight_cost";
	public static final String CARDAMCOST_COLUMN_PUNCTW_C = "punctured_wheel_cost";
	public static final String CARDAMCOST_COLUMN_LARGE_DENT_C = "large_dent_cost";
	public static final String CARDAMCOST_COLUMN_ENDAMAGE_C = "engine_damage_cost";
	public static final String CARDAMCOST_COLUMN_HUGEDAM_C = "huge_damage_cost";
	
	public static final String DAMHIST_COLUMN_ID = "id";
	public static final String DAMHIST_COLUMN_ORDER_ID = "order_id";
	public static final String DAMHIST_COLUMN_CAR_ID = "car_id";
	public static final String DAMHIST_COLUMN_CRACKEDWS = "cracked_windshield";
	public static final String DAMHIST_COLUMN_SMALL_DENT = "small_dent";
	public static final String DAMHIST_COLUMN_BROKENHL = "broken_headlight";
	public static final String DAMHIST_COLUMN_PUNCTW = "punctured_wheel";
	public static final String DAMHIST_COLUMN_LARGE_DENT = "large_dent";
	public static final String DAMHIST_COLUMN_ENDAMAGE = "engine_damage";
	public static final String DAMHIST_COLUMN_HUGEDAM = "huge_damage";
	
	

}
