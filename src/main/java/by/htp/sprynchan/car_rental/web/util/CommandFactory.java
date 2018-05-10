package by.htp.sprynchan.car_rental.web.util;

import javax.servlet.http.HttpServletRequest;

import by.htp.sprynchan.car_rental.web.commands.BaseCommand;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.AddCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.AddDamageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.AddingCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.ApproveOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.DeleteCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.EditCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.FinishOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.MarkAsReturnedCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.RejectOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.ReportDamagesCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.SendDamageReportCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.SendRejectMessageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.ShowOrdersByStatusCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.UpdateCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.ViewCarParkCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.admin.ViewOrderDetailsCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.AuthorizationCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.IndexPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.RegisterCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.RegistrationPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.SignOutCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.all.ToMyProfilePageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.BookCarCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.CancelOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangeAccountInfoCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangeOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangePasswordCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangingAccountInfoPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangingOrderPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ChangingPasswordPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.CreateOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.DeleteAccountCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.DeleteAccountPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.DepositPageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.MakeDepositCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.PayForDamageCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.PayForOrderCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.SubmitOrderFormCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ViewAccountDetailsCommandImpl;
import by.htp.sprynchan.car_rental.web.commands.impl.user.ViewMyOrdersCommandImpl;

public class CommandFactory {
	
	private static final String COMMAND = "command";

	public static BaseCommand defineCommand(HttpServletRequest request) {
		
		BaseCommand command = null;
		
		String inputCommand =  request.getParameter(COMMAND);
		if(inputCommand == null) {
			inputCommand = "INDEX_PAGE";
		}
		
		CommandEnum commandName = CommandEnum.valueOf(inputCommand);

		
		System.out.println(inputCommand);
		
		switch(commandName) {
		case ADD_DAMAGE:
			command = new AddDamageCommandImpl();
			break;
		case CANCEL_ORDER:
			command = new CancelOrderCommandImpl();
			break;
		case CHANGE_ORDER:
			command = new ChangeOrderCommandImpl();
			break;
		case CHANGING_ORDER_PAGE:
			command = new ChangingOrderPageCommandImpl();
			break;
		case CHANGE_ACCOUNT_INFO:
			command = new ChangeAccountInfoCommandImpl();
			break;
		case CHANGING_ACCOUNT_INFO_PAGE:
			command = new ChangingAccountInfoPageCommandImpl();
			break;
		case CHANGE_PASSWORD:
			command = new ChangePasswordCommandImpl();
			break;
		case CHANGING_PASSWORD_PAGE:
			command = new ChangingPasswordPageCommandImpl();
			break;
		case DELETE_ACCOUNT:
			command = new DeleteAccountCommandImpl();
			break;
		case DELETE_ACCOUNT_PAGE:
			command = new DeleteAccountPageCommandImpl();
			break;
		case MAKE_DEPOSIT:
			command = new MakeDepositCommandImpl();
			break;
		case DEPOSIT_PAGE:
			command = new DepositPageCommandImpl();
			break;
		case VIEW_ACCOUNT_DETAILS:
			command = new ViewAccountDetailsCommandImpl();
			break;
		case SHOW_ORDERS_BY_STATUS:
			command = new ShowOrdersByStatusCommandImpl();
			 break;
		case INDEX_PAGE:
			command = new IndexPageCommandImpl();
			break;
		case TO_MY_PROFILE_PAGE:
			command = new ToMyProfilePageCommandImpl();
			break;
		case PAY_FOR_DAMAGE:
			command = new PayForDamageCommandImpl();
			break;
		case PAY_FOR_ORDER:
			command = new PayForOrderCommandImpl();
			break;
		case VIEW_MY_ORDERS:
			command = new ViewMyOrdersCommandImpl();
			break;		
		case FINISH_ORDER:
			command = new FinishOrderCommandImpl();
			break;
		case SEND_DAMAGE_REPORT:
			command = new SendDamageReportCommandImpl();
			break;
		case REPORT_DAMAGES:
			command = new ReportDamagesCommandImpl();
			break;
		case SEND_REJECT_MESSAGE:
			command = new SendRejectMessageCommandImpl();
			break;
		case MARK_AS_RETURNED:
			command = new MarkAsReturnedCommandImpl();
			break;
		case REJECT_ORDER:
			command = new RejectOrderCommandImpl();
			break;
		case APPROVE_ORDER:
			command = new ApproveOrderCommandImpl();
			break;
		case SUBMIT_ORDER_FORM:
			command = new SubmitOrderFormCommandImpl();
			break;
		case VIEW_ORDER_DETAILS:
			command = new ViewOrderDetailsCommandImpl();
			break;
		case CREATE_ORDER:
			command = new CreateOrderCommandImpl();
			break;
		case BOOK_CAR:
			command = new BookCarCommandImpl();
			break;
		case ADDING_CAR:
			command = new AddingCarCommandImpl();
			break;
		case ADD_CAR:
			command = new AddCarCommandImpl();
			break;
		case VIEW_CAR_PARK:
			command = new ViewCarParkCommandImpl();
			break;
		case DELETE_CAR:
			command = new DeleteCarCommandImpl();
			break;				
		case EDIT_CAR:
			command = new EditCarCommandImpl();
			break;
		case UPDATE_CAR:
			command = new UpdateCarCommandImpl();
			break;
		case REGISTRATION_PAGE:
			command = new RegistrationPageCommandImpl();
			break;
		case REGISTER:
			command = new RegisterCommandImpl();
			break;
		case SIGN_OUT:
			command = new SignOutCommandImpl();
			break;
		case AUTHORIZATION:
			command = new AuthorizationCommandImpl();
			break;
		}
		return command;

	}
}
