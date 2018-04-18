package by.htp.sprynchan.car_rental.bean;

import java.util.Date;

import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class Order extends Entity {

	private static final long serialVersionUID = 1313667974838997492L;
	
	private OrderStatusEnum status;
	private Date orderDate;
	private String customerName;
	private String customerSurname;
	private int userId;
	private String passportNumb;
	private Date dateOfBirth;
	private int drivingExp;
	private int carId;
	private Date startDate;
	private Date endDate;
	private int totalPrice;
	private boolean isDamaged;
	private int damageAmount;
	private String rejectionReason;

	public Order() {
	}

	public Order(int id) {
		super(id);
	}

	public Order(OrderStatusEnum status, Date orderDate, String customerName, String customerSurname, int customerId,
			String passportNumb, Date dateOfBirth, int drivingExp, int carId, Date startDate, Date endDate,
			String rejectionReason) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.userId = customerId;
		this.passportNumb = passportNumb;
		this.dateOfBirth = dateOfBirth;
		this.drivingExp = drivingExp;
		this.carId = carId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rejectionReason = rejectionReason;

	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int customerId) {
		this.userId = customerId;
	}

	public String getPassportNumb() {
		return passportNumb;
	}

	public void setPassportNumb(String passportNumb) {
		this.passportNumb = passportNumb;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getDrivingExp() {
		return drivingExp;
	}

	public void setDrivingExp(int drivingExp) {
		this.drivingExp = drivingExp;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isDamaged() {
		return isDamaged;
	}

	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}

	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + carId;
		result = prime * result + userId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerSurname == null) ? 0 : customerSurname.hashCode());
		result = prime * result + damageAmount;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + drivingExp;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (isDamaged ? 1231 : 1237);
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((passportNumb == null) ? 0 : passportNumb.hashCode());
		result = prime * result + ((rejectionReason == null) ? 0 : rejectionReason.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalPrice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (carId != other.carId)
			return false;
		if (userId != other.userId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerSurname == null) {
			if (other.customerSurname != null)
				return false;
		} else if (!customerSurname.equals(other.customerSurname))
			return false;
		if (damageAmount != other.damageAmount)
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (drivingExp != other.drivingExp)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isDamaged != other.isDamaged)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (passportNumb == null) {
			if (other.passportNumb != null)
				return false;
		} else if (!passportNumb.equals(other.passportNumb))
			return false;
		if (rejectionReason == null) {
			if (other.rejectionReason != null)
				return false;
		} else if (!rejectionReason.equals(other.rejectionReason))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status != other.status)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", orderDate=" + orderDate + ", customerName=" + customerName
				+ ", customerSurname=" + customerSurname + ", userId=" + userId + ", passportNumb=" + passportNumb
				+ ", dateOfBirth=" + dateOfBirth + ", drivingExp=" + drivingExp + ", carId=" + carId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", totalPrice=" + totalPrice + ", isDamaged=" + isDamaged
				+ ", damageAmount=" + damageAmount + ", rejectionReason=" + rejectionReason + "]";
	}

}
