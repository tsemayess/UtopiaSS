package com.smoothstack.utopia.domains;

public class BookingUser {
	private Integer booking, user;
	/**
	 * @return the booking
	 */
	public int getBooking() {
		return booking;
	}
	/**
	 * @param booking the booking to set
	 */
	public void setBooking(int booking) {
		this.booking = booking;
	}
	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		BookingUser other = (BookingUser) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
