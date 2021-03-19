package com.smoothstack.utopia.domains;

public class BookingGuest {
	private Booking booking;
	private StringBuffer email, phone;
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
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		BookingGuest other = (BookingGuest) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	

}
