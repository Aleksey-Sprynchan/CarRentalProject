package by.htp.sprynchan.car_rental.web.util;

public enum CommandEnum {

	AUTHORIZATION(UserTypeEnum.ALL),
	SIGN_OUT(UserTypeEnum.ALL),
	REGISTRATION_PAGE(UserTypeEnum.ALL),
	REGISTER(UserTypeEnum.ALL),
	START_PAGE(UserTypeEnum.ALL),
	TO_MY_PROFILE_PAGE(UserTypeEnum.ALL),
	REDIRECT_GUEST(UserTypeEnum.ALL),
	SIGN_IN_PAGE(UserTypeEnum.ALL),
	CHANGE_LOCALE(UserTypeEnum.ALL),
	
	BOOK_CAR(UserTypeEnum.USER),
	CREATE_ORDER(UserTypeEnum.USER),
	PAY_FOR_ORDER(UserTypeEnum.USER),
	PAY_FOR_DAMAGE(UserTypeEnum.USER),
	VIEW_ACCOUNT_DETAILS(UserTypeEnum.USER),
	DEPOSIT_PAGE(UserTypeEnum.USER),
	MAKE_DEPOSIT(UserTypeEnum.USER),
	DELETE_ACCOUNT_PAGE(UserTypeEnum.USER),
	DELETE_ACCOUNT(UserTypeEnum.USER),
	CHANGING_PASSWORD_PAGE(UserTypeEnum.USER),
	CHANGE_PASSWORD(UserTypeEnum.USER),
	CHANGING_PERSONAL_INFO_PAGE(UserTypeEnum.USER),
	CHANGE_PERSONAL_INFO(UserTypeEnum.USER),
	CHANGING_ORDER_PAGE(UserTypeEnum.USER),
	CHANGE_ORDER(UserTypeEnum.USER),
	CANCEL_ORDER(UserTypeEnum.USER),
	VIEW_ORDER_DETAILS(UserTypeEnum.USER),
	REDIRECT_USER(UserTypeEnum.USER),

	CREATE_CAR(UserTypeEnum.ADMIN),
	SHOW_ORDERS_BY_STATUS(UserTypeEnum.ADMIN),	
	ADD_CAR(UserTypeEnum.ADMIN),
	VIEW_CAR_PARK(UserTypeEnum.ADMIN),
	DELETE_CAR(UserTypeEnum.ADMIN),
	EDIT_CAR(UserTypeEnum.ADMIN),
	UPDATE_CAR(UserTypeEnum.ADMIN),
	MANAGE_ORDER(UserTypeEnum.ADMIN),
	APPROVE_ORDER(UserTypeEnum.ADMIN),
	REJECT_ORDER(UserTypeEnum.ADMIN),
	MARK_AS_RETURNED(UserTypeEnum.ADMIN),
	SEND_REJECT_MESSAGE(UserTypeEnum.ADMIN),
	REPORT_DAMAGES(UserTypeEnum.ADMIN),
	SEND_DAMAGE_REPORT(UserTypeEnum.ADMIN),
	FINISH_ORDER(UserTypeEnum.ADMIN),
	VIEW_CAR_DAMAGE_HISTORY(UserTypeEnum.ADMIN),
	VIEW_USER_ORDERS(UserTypeEnum.ADMIN),
	VIEW_USER_LIST(UserTypeEnum.ADMIN),
	REDIRECT_ADMIN(UserTypeEnum.ADMIN);

	private UserTypeEnum userType;

	private CommandEnum(UserTypeEnum userType) {
		this.userType = userType;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}
	
	public static CommandEnum valueOfOrDefault(String value) {
		for(CommandEnum command: CommandEnum.class.getEnumConstants()) {
			if(command.name().equals(value)) {
				return command;
			}
		}
		return CommandEnum.START_PAGE;
	}

}
