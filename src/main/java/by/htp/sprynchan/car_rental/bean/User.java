package by.htp.sprynchan.car_rental.bean;

/**
 * Class describing User entity from database
 * 
 * @author Aleksey Sprynchan
 *
 */
public class User extends Entity {
	
	private static final long serialVersionUID = -6195181364789221777L;
	
	/**
	 * Login of user
	 */
	private String login;
	/**
	 * Password of user
	 */
	private String password;
	/**
	 * Name of user
	 */
	private String name;
	/**
	 * Surname of user
	 */
	private String surname;
	/**
	 * Email of user
	 */
	private String email;
	/**
	 * Account actual balance of user
	 */
	private int balance;
	/**
	 * Variable that shows the role of user
	 */
	private boolean isAdmin;
	
	public User() {}

	public User(int id) {
		super(id);
	}

	public User(String login, String password, String name, String surname, String email) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + balance;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (balance != other.balance)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", balance=" + balance + ", isAdmin=" + isAdmin + ", getId()=" + getId() + "]";
	}

}
