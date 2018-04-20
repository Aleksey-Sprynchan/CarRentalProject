package by.htp.sprynchan.car_rental.bean;

import java.util.Date;

import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class Order extends Entity {

	private static final long serialVersionUID = 5169169366838229002L;
	
	private OrderStatusEnum status;
	private Date orderDate;
	private int userId; 
	private int carId;
	private Date startDate;
	private Date endDate;
	private CustomerPersonalData customer;
	private int totalPrice;
	private boolean isDamaged;
	private int damageAmount;
	private String rejectionReason;

	public Order() {}

	public Order(int id) {
		super(id);
	}

	public Order(OrderStatusEnum status, Date orderDate, int userId, int carId, Date startDate, Date endDate,
			CustomerPersonalData customer, int totalPrice, boolean isDamaged, int damageAmount,
			String rejectionReason) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.userId = userId;
		this.carId = carId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.isDamaged = isDamaged;
		this.damageAmount = damageAmount;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public CustomerPersonalData getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPersonalData customer) {
		this.customer = customer;
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
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + damageAmount;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (isDamaged ? 1231 : 1237);
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((rejectionReason == null) ? 0 : rejectionReason.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalPrice;
		result = prime * result + userId;
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (damageAmount != other.damageAmount)
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
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", orderDate=" + orderDate + ", userId=" + userId + ", carId=" + carId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", customer=" + customer + ", totalPrice="
				+ totalPrice + ", isDamaged=" + isDamaged + ", damageAmount=" + damageAmount + ", rejectionReason="
				+ rejectionReason + ", getId()=" + getId() + "]";
	}
	

}
