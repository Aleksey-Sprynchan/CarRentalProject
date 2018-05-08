package by.htp.sprynchan.car_rental.bean;

public class DamageHistory extends Entity {
	
	private static final long serialVersionUID = -8715945413604117165L;
	
	private int orderId;
	private int carId;
	private boolean crackedWindshield;
	private boolean smallDent;
	private boolean brokenHeadlight;
	private boolean puncturedWheel;
	private boolean largeDent;
	private boolean engineDamage;
	private boolean hugeDamage;
	
	public DamageHistory() {
	}
	
	public DamageHistory(int id) {
		super(id);
	}

	public DamageHistory(int orderId, int carId, boolean crackedWindshield, boolean smallDent, boolean brokenHeadlight,
			boolean puncturedWheel, boolean largeDent, boolean engineDamage, boolean hugeDamage) {
		super();
		this.orderId = orderId;
		this.carId = carId;
		this.crackedWindshield = crackedWindshield;
		this.smallDent = smallDent;
		this.brokenHeadlight = brokenHeadlight;
		this.puncturedWheel = puncturedWheel;
		this.largeDent = largeDent;
		this.engineDamage = engineDamage;
		this.hugeDamage = hugeDamage;
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

	public boolean isCrackedWindshield() {
		return crackedWindshield;
	}

	public void setCrackedWindshield(boolean crackedWindshield) {
		this.crackedWindshield = crackedWindshield;
	}

	public boolean isSmallDent() {
		return smallDent;
	}

	public void setSmallDent(boolean smallDent) {
		this.smallDent = smallDent;
	}

	public boolean isBrokenHeadlight() {
		return brokenHeadlight;
	}

	public void setBrokenHeadlight(boolean brokenHeadlight) {
		this.brokenHeadlight = brokenHeadlight;
	}

	public boolean isPuncturedWheel() {
		return puncturedWheel;
	}

	public void setPuncturedWheel(boolean puncturedWheel) {
		this.puncturedWheel = puncturedWheel;
	}

	public boolean isLargeDent() {
		return largeDent;
	}

	public void setLargeDent(boolean largeDent) {
		this.largeDent = largeDent;
	}

	public boolean isEngineDamage() {
		return engineDamage;
	}

	public void setEngineDamage(boolean engineDamage) {
		this.engineDamage = engineDamage;
	}

	public boolean isHugeDamage() {
		return hugeDamage;
	}

	public void setHugeDamage(boolean hugeDamage) {
		this.hugeDamage = hugeDamage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (brokenHeadlight ? 1231 : 1237);
		result = prime * result + carId;
		result = prime * result + (crackedWindshield ? 1231 : 1237);
		result = prime * result + (engineDamage ? 1231 : 1237);
		result = prime * result + (hugeDamage ? 1231 : 1237);
		result = prime * result + (largeDent ? 1231 : 1237);
		result = prime * result + orderId;
		result = prime * result + (puncturedWheel ? 1231 : 1237);
		result = prime * result + (smallDent ? 1231 : 1237);
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
		DamageHistory other = (DamageHistory) obj;
		if (brokenHeadlight != other.brokenHeadlight)
			return false;
		if (carId != other.carId)
			return false;
		if (crackedWindshield != other.crackedWindshield)
			return false;
		if (engineDamage != other.engineDamage)
			return false;
		if (hugeDamage != other.hugeDamage)
			return false;
		if (largeDent != other.largeDent)
			return false;
		if (orderId != other.orderId)
			return false;
		if (puncturedWheel != other.puncturedWheel)
			return false;
		if (smallDent != other.smallDent)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DamageHistory [orderId=" + orderId + ", carId=" + carId + ", crackedWindshield=" + crackedWindshield
				+ ", smallDent=" + smallDent + ", brokenHeadlight=" + brokenHeadlight + ", puncturedWheel="
				+ puncturedWheel + ", largeDent=" + largeDent + ", engineDamage=" + engineDamage + ", hugeDamage="
				+ hugeDamage + ", getId()=" + getId() + "]";
	}
	
}
