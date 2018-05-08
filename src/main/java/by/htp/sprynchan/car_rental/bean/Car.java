package by.htp.sprynchan.car_rental.bean;

public class Car extends Entity {

	private static final long serialVersionUID = 5101074728089686144L;

	private String brandName;
	private String model;
	private String type;
	private String transmission;
	private int doors;
	private int passengers;
	private String fuel;
	private boolean isAirCondition;
	private int pricePerDay;
	private boolean isAvailable;

	public Car() {
	}

	public Car(int id) {
		super(id);
	}

	public Car(String brandName, String model, String type, String transmission, int doors, int passengers, String fuel,
			boolean isAirCondition, int pricePerDay, boolean isAvailable) {
		this.brandName = brandName;
		this.model = model;
		this.type = type;
		this.transmission = transmission;
		this.doors = doors;
		this.passengers = passengers;
		this.fuel = fuel;
		this.isAirCondition = isAirCondition;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
	}

	public Car(int id, String brandName, String model, String type, String transmission, int doors, int passengers, String fuel,
			boolean isAirCondition, int pricePerDay, boolean isAvailable) {
		super(id);
		this.brandName = brandName;
		this.model = model;
		this.type = type;
		this.transmission = transmission;
		this.doors = doors;
		this.passengers = passengers;
		this.fuel = fuel;
		this.isAirCondition = isAirCondition;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public boolean isAirCondition() {
		return isAirCondition;
	}

	public void setAirCondition(boolean isAirCondition) {
		this.isAirCondition = isAirCondition;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + doors;
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + (isAirCondition ? 1231 : 1237);
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + passengers;
		result = prime * result + pricePerDay;
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Car other = (Car) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (doors != other.doors)
			return false;
		if (fuel == null) {
			if (other.fuel != null)
				return false;
		} else if (!fuel.equals(other.fuel))
			return false;
		if (isAirCondition != other.isAirCondition)
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (passengers != other.passengers)
			return false;
		if (pricePerDay != other.pricePerDay)
			return false;
		if (transmission == null) {
			if (other.transmission != null)
				return false;
		} else if (!transmission.equals(other.transmission))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [brandName=" + brandName + ", model=" + model + ", type=" + type + ", transmission=" + transmission
				+ ", doors=" + doors + ", passengers=" + passengers + ", fuel=" + fuel + ", isAirCondition="
				+ isAirCondition + ", pricePerDay=" + pricePerDay + ", isAvailable=" + isAvailable + "]";
	}


}
