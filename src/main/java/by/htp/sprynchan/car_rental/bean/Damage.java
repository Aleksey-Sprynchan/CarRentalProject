package by.htp.sprynchan.car_rental.bean;

/**
 * Class describing Damage entity from database
 * 
 * @author Aleksey Sprynchan
 *
 */
public class Damage extends Entity {

	private static final long serialVersionUID = 4157582143657734882L;

	/**
	 * Id of order where damages where detected
	 */
	private int orderId;
	/**
	 * Id of car which were damaged
	 */
	private int carId;
	/**
	 * Name of damage
	 */
	private String damageName;
	/**
	 * Cost of repair
	 */
	private int damageCost;
		
	public Damage() {}

	public Damage(int id) {
		super(id);
	}

	public Damage(int orderId, int carId, String damageName, int damageCost) {
		super();
		this.orderId = orderId;
		this.carId = carId;
		this.damageName = damageName;
		this.damageCost = damageCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getDamageName() {
		return damageName;
	}

	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}

	public int getDamageCost() {
		return damageCost;
	}

	public void setDamageCost(int damageCost) {
		this.damageCost = damageCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + carId;
		result = prime * result + damageCost;
		result = prime * result + ((damageName == null) ? 0 : damageName.hashCode());
		result = prime * result + orderId;
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
		Damage other = (Damage) obj;
		if (carId != other.carId)
			return false;
		if (damageCost != other.damageCost)
			return false;
		if (damageName == null) {
			if (other.damageName != null)
				return false;
		} else if (!damageName.equals(other.damageName))
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Damage [orderId=" + orderId + ", carId=" + carId + ", damageName=" + damageName + ", damageCost="
				+ damageCost + ", getId()=" + getId() + "]";
	}

}
