package com.smoothstack.utopia.domains;

public class Flight {
	private Integer iD, route,airplane, seats;
	private Float price;
	private StringBuffer departure, arrival;
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival.toString();
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = new StringBuffer(arrival);
	}
	/**
	 * @return the iD
	 */
	public Integer getiD() {
		return iD;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setiD(Integer iD) {
		this.iD = iD;
	}
	/**
	 * @return the route
	 */
	public Integer getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(Integer route) {
		this.route = route;
	}
	/**
	 * @return the airplane
	 */
	public Integer getAirplane() {
		return airplane;
	}
	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(Integer airplane) {
		this.airplane = airplane;
	}
	/**
	 * @return the seats
	 */
	public Integer getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure.toString();
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = new StringBuffer(departure);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iD == null) ? 0 : iD.hashCode());
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
		Flight other = (Flight) obj;
		if (iD == null) {
			if (other.iD != null)
				return false;
		} else if (!iD.equals(other.iD))
			return false;
		return true;
	}
	
	
	
}
