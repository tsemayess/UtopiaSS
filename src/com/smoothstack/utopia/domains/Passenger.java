package com.smoothstack.utopia.domains;

public class Passenger {
	private Integer iD;
	Booking booking;
	StringBuffer firstName, lastName, gender, dob, address;
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
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}
	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
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
	 * @return the gender
	 */
	public String getGender() {
		return gender.toString();
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = new StringBuffer(gender);
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob.toString();
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = new StringBuffer(dob);
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address.toString();
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = new StringBuffer(address);
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
		Passenger other = (Passenger) obj;
		if (iD != other.iD)
			return false;
		return true;
	}
}
