package com.smoothstack.utopia.domains;

public class FlightBooking {
	private Flight flight;
	private Booking booking;
	
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	/**
	 * @return the booking
	 */
	public Booking getbooking() {
		return booking;
	}
	/**
	 * @param booking the booking to set
	 */
	public void setbooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
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
		FlightBooking other = (FlightBooking) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		return true;
	}
	
	
}
