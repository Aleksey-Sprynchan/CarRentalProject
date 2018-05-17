package by.htp.sprynchan.car_rental.web.util;

public final class PagePathConstantPool {

	private PagePathConstantPool() {
		throw new IllegalStateException("Utility class");
	}	
		
	public static final String PAGE_START_PAGE = "/WEB-INF/start_page.jsp";
	public static final String PAGE_INDEX = "/jsp/index.jsp";
	public static final String PAGE_CAR_PARK = "/WEB-INF/car_park.jsp";	
	public static final String PAGE_REGISTRATION = "/jsp/registration.jsp";	
	public static final String PAGE_USER_PROFILE = "/WEB-INF/user_profile.jsp";
	public static final String PAGE_ADMIN_PROFILE = "/WEB-INF/admin_profile.jsp";
	public static final String PAGE_CREATE_CAR = "/WEB-INF/create_car.jsp";
	public static final String PAGE_EDIT_CAR = "/WEB-INF/edit_car.jsp";
	public static final String PAGE_BOOK_CAR = "/WEB-INF/book_car.jsp";
	public static final String PAGE_ORDER_DETAILS = "/WEB-INF/order_details.jsp";
	public static final String PAGE_REJECTION_FORM = "/WEB-INF/rejection_form.jsp";	
	public static final String PAGE_REPORT_DAMAGES = "/WEB-INF/report_damages.jsp";
	public static final String PAGE_MY_ORDERS = "/WEB-INF/my_orders.jsp";	
	public static final String PAGE_USER_ACCOUNT_SETTINGS = "/WEB-INF/account_settings.jsp";
	public static final String PAGE_DEPOSIT = "/WEB-INF/deposit.jsp";
	public static final String PAGE_DELETE_ACCOUNT = "/WEB-INF/delete_account.jsp";
	public static final String PAGE_CHANGE_PASS = "/WEB-INF/change_password.jsp";
	public static final String PAGE_CHANGE_ACCOUNT_INFO = "/WEB-INF/change_account_info.jsp";	
	public static final String PAGE_CHANGE_ORDER= "/WEB-INF/change_order.jsp";
	public static final String PAGE_CAR_DAMAGE_HISTORY= "/WEB-INF/car_damage_history.jsp";
	public static final String PAGE_USERS_LIST= "/WEB-INF/users_list.jsp";
	public static final String PAGE_USER_ORDERS = "/WEB-INF/user_orders.jsp";	
	
	
	public static final String PAGE_ERROR = "/jsp/404.html";
	
	public static final String REDIRECT_ADMIN_URL = "/CarRentalServlet?command=REDIRECT_ADMIN";
	public static final String REDIRECT_USER_URL = "/CarRentalServlet?command=REDIRECT_USER";
	public static final String REDIRECT_GUEST_URL = "/CarRentalServlet?command=REDIRECT_GUEST";

}
