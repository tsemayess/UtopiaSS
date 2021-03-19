package com.smoothstack.utopia.domains;

public class BookingPayment {
	private Booking booking;
	private Integer stripeID, refunded;
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
	 * @return the stripeID
	 */
	public int getStripeID() {
		return stripeID;
	}
	/**
	 * @param stripeID the stripeID to set
	 */
	public void setStripeID(int stripeID) {
		this.stripeID = stripeID;
	}
	/**
	 * @return the refunded
	 */
	public int getRefunded() {
		return refunded;
	}
	/**
	 * @param refunded the refunded to set
	 */
	public void setRefunded(int refunded) {
		this.refunded = refunded;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
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
		BookingPayment other = (BookingPayment) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		return true;
	}
	
	
}
