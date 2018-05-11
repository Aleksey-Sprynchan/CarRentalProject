package by.htp.sprynchan.car_rental.bean;

public class Car extends Entity {
	
	private static final long serialVersionUID = 1937498168638918279L;
	
	private String brandName;
	private String model;
	private String type;
	private String transmission;
	private int passengers;
	private String fuel;
	private boolean isAirCondition;
	private int pricePerDay;
	private boolean isAvailable;
	private String image;

	public Car() {}

	public Car(int id) {
		super(id);
	}

	public Car(String brandName, String model, String type, String transmission, int passengers, String fuel,
			boolean isAirCondition, int pricePerDay, boolean isAvailable, String image) {
		super();
		this.brandName = brandName;
		this.model = model;
		this.type = type;
		this.transmission = transmission;
		this.passengers = passengers;
		this.fuel = fuel;
		this.isAirCondition = isAirCondition;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
		this.image = image;
	}

	public Car(int id, String brandName, String model, String type, String transmission, int passengers, String fuel,
			boolean isAirCondition, int pricePerDay, boolean isAvailable, String image) {
		super(id);
		this.brandName = brandName;
		this.model = model;
		this.type = type;
		this.transmission = transmission;
		this.passengers = passengers;
		this.fuel = fuel;
		this.isAirCondition = isAirCondition;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		if (fuel == null) {
			if (other.fuel != null)
				return false;
		} else if (!fuel.equals(other.fuel))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
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
		return brandName + " " + model + " (" + type + ") "+ transmission + " transmission ," 
				+ passengers + " passengers "+ " " + fuel + " , Air condition=" + isAirCondition
				+ " " + "only " + pricePerDay + "$/day";
	}
	
}
