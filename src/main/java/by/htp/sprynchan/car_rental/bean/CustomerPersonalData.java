package by.htp.sprynchan.car_rental.bean;

import java.time.LocalDate;


public class CustomerPersonalData extends Entity {
	
	private static final long serialVersionUID = -1864812238811847229L;
	
	private String name;
	private String surname;
	private String passportNumb;
	private LocalDate dateOfBirth;
	private int drivingExp;
		
	public CustomerPersonalData() {}

	public CustomerPersonalData(int id) {
		super(id);
	}


	public CustomerPersonalData(String name, String surname, String passportNumb, LocalDate dateOfBirth, int drivingExp) {
		super();
		this.name = name;
		this.surname = surname;
		this.passportNumb = passportNumb;
		this.dateOfBirth = dateOfBirth;
		this.drivingExp = drivingExp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassportNumb() {
		return passportNumb;
	}

	public void setPassportNumb(String passportNumb) {
		this.passportNumb = passportNumb;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getDrivingExp() {
		return drivingExp;
	}

	public void setDrivingExp(int drivingExp) {
		this.drivingExp = drivingExp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + drivingExp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passportNumb == null) ? 0 : passportNumb.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		CustomerPersonalData other = (CustomerPersonalData) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (drivingExp != other.drivingExp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passportNumb == null) {
			if (other.passportNumb != null)
				return false;
		} else if (!passportNumb.equals(other.passportNumb))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CustomerPersonalData [name=" + name + ", surname=" + surname + ", passportNumb=" + passportNumb
				+ ", dateOfBirth=" + dateOfBirth + ", drivingExp=" + drivingExp + ", getId()=" + getId() + "]";
	}


}
