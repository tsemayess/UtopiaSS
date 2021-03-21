package com.smoothstack.utopia.domains;

public class Booking {
	private Integer bookingID, isActive, flight;

	/**
	 * @return the flight
	 */
	public int getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(int flight) {
		this.flight = flight;
	}

	StringBuffer ConfirmationCode;

	/**
	 * @return the bookingID
	 */
	public int getBookingID() {
		return bookingID;
	}

	/**
	 * @param bookingID the bookingID to set
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * @return the isActive
	 */
	public int getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String isActiveString() {
	
		String s = "";
		switch(isActive) {
		case 1:
			s = "ACTIVE";
			break;
		case 2:
			s = "CANCELLED";
			break;
		}
	return s;
	}

	/**
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return ConfirmationCode.toString();
	}

	/**
	 * @param confirmationCode the confirmationCode to set
	 */
	public void setConfirmationCode(String confirmationCode) {
		ConfirmationCode = new StringBuffer(confirmationCode);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingID;
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
		Booking other = (Booking) obj;
		if (bookingID != other.bookingID)
			return false;
		return true;
	}

}
