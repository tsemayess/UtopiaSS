package com.smoothstack.utopia.domains;

public class User {
	private Integer iD;
	private UserRole role;
	private StringBuffer firstName, lastName, username, email, password, phone;
	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setiD(int iD) {
		this.iD = iD;
	}
	/**
	 * @return the role
	 */
	public UserRole getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName.toString();
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = new StringBuffer(firstName);
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName.toString();
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = new StringBuffer(lastName);
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username.toString();
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = new StringBuffer(username);
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email.toString();
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = new StringBuffer(email);
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password.toString();
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = new StringBuffer(password);
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone.toString();
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = new StringBuffer(phone);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iD;
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
		User other = (User) obj;
		if (iD != other.iD)
			return false;
		return true;
	}
	

}
