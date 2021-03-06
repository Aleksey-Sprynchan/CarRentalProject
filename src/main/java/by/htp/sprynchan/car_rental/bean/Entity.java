package by.htp.sprynchan.car_rental.bean;

import java.io.Serializable;

/**
 * Class parent for all this application entities
 * 
 * @author Aleksey Sprynchan
 *
 */
public abstract class Entity implements Serializable{
	
	private static final long serialVersionUID = -6942013610688656186L;

	/**
	 * Common ID field for all entities
	 */
	private int id;

	public Entity() {
		super();		
	}

	public Entity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}

}
