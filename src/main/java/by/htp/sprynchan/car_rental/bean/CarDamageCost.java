package by.htp.sprynchan.car_rental.bean;

public class CarDamageCost extends Entity {
	
	private static final long serialVersionUID = -187834302546605656L;
	
	private int carId;
	private int crackedWindshieldCost;
	private int smallDentCost;
	private int brokenHeadlightCost;
	private int puncturedWheelCost;
	private int largeDentCost;
	private int engineDamageCost;
	private int hugeDamageCost;
	
	public CarDamageCost() {
	}
	
	public CarDamageCost(int id) {
		super(id);
	}

	public CarDamageCost(int carId, int crackedWindshieldCost, int smallDentCost, int brokenHeadlightCost,
			int puncturedWheelCost, int largeDentCost, int engineDamageCost, int hugeDamageCost) {		
		this.carId = carId;
		this.crackedWindshieldCost = crackedWindshieldCost;
		this.smallDentCost = smallDentCost;
		this.brokenHeadlightCost = brokenHeadlightCost;
		this.puncturedWheelCost = puncturedWheelCost;
		this.largeDentCost = largeDentCost;
		this.engineDamageCost = engineDamageCost;
		this.hugeDamageCost = hugeDamageCost;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getCrackedWindshieldCost() {
		return crackedWindshieldCost;
	}

	public void setCrackedWindshieldCost(int crackedWindshieldCost) {
		this.crackedWindshieldCost = crackedWindshieldCost;
	}

	public int getSmallDentCost() {
		return smallDentCost;
	}

	public void setSmallDentCost(int smallDentCost) {
		this.smallDentCost = smallDentCost;
	}

	public int getBrokenHeadlightCost() {
		return brokenHeadlightCost;
	}

	public void setBrokenHeadlightCost(int brokenHeadlightCost) {
		this.brokenHeadlightCost = brokenHeadlightCost;
	}

	public int getPuncturedWheelCost() {
		return puncturedWheelCost;
	}

	public void setPuncturedWheelCost(int puncturedWheelCost) {
		this.puncturedWheelCost = puncturedWheelCost;
	}

	public int getLargeDentCost() {
		return largeDentCost;
	}

	public void setLargeDentCost(int largeDentCost) {
		this.largeDentCost = largeDentCost;
	}

	public int getEngineDamageCost() {
		return engineDamageCost;
	}

	public void setEngineDamageCost(int engineDamageCost) {
		this.engineDamageCost = engineDamageCost;
	}

	public int getHugeDamageCost() {
		return hugeDamageCost;
	}

	public void setHugeDamageCost(int hugeDamageCost) {
		this.hugeDamageCost = hugeDamageCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + brokenHeadlightCost;
		result = prime * result + carId;
		result = prime * result + crackedWindshieldCost;
		result = prime * result + engineDamageCost;
		result = prime * result + hugeDamageCost;
		result = prime * result + largeDentCost;
		result = prime * result + puncturedWheelCost;
		result = prime * result + smallDentCost;
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
		CarDamageCost other = (CarDamageCost) obj;
		if (brokenHeadlightCost != other.brokenHeadlightCost)
			return false;
		if (carId != other.carId)
			return false;
		if (crackedWindshieldCost != other.crackedWindshieldCost)
			return false;
		if (engineDamageCost != other.engineDamageCost)
			return false;
		if (hugeDamageCost != other.hugeDamageCost)
			return false;
		if (largeDentCost != other.largeDentCost)
			return false;
		if (puncturedWheelCost != other.puncturedWheelCost)
			return false;
		if (smallDentCost != other.smallDentCost)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarDamageCost [carId=" + carId + ", crackedWindshieldCost=" + crackedWindshieldCost + ", smallDentCost="
				+ smallDentCost + ", brokenHeadlightCost=" + brokenHeadlightCost + ", puncturedWheelCost="
				+ puncturedWheelCost + ", largeDentCost=" + largeDentCost + ", engineDamageCost=" + engineDamageCost
				+ ", hugeDamageCost=" + hugeDamageCost + ", getId()=" + getId() + "]";
	}
	
	
}
