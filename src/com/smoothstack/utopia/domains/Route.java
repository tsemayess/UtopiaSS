package com.smoothstack.utopia.domains;

public class Route {
	private Integer routeId;
	private StringBuffer origin, destination;
	
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin.toString();
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = new StringBuffer(origin);
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination.toString();
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = new StringBuffer(destination);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
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
		Route other = (Route) obj;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		return true;
	}

}
