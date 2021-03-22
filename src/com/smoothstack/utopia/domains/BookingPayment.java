package com.smoothstack.utopia.domains;

public class BookingPayment {
	private Integer booking, refunded;
	private StringBuffer payment;
	/**
	 * @return the booking
	 */
	public Integer getBooking() {
		return booking;
	}
	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Integer booking) {
		this.booking = booking;
	}
	/**
	 * @return the refunded
	 */
	public Integer getRefunded() {
		return refunded;
	}
	/**
	 * @param refunded the refunded to set
	 */
	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}
	
	public String refundedString() {
		if (refunded == 1) {
			return "NO";
		} else if (refunded == 2){
			return "YES";
		}
		return "ERROR";
	}
	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment.toString();
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = new StringBuffer(payment);
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
