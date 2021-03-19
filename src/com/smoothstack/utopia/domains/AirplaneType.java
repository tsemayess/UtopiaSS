/**
 * 
 */
package com.smoothstack.utopia.domains;

/**
 * @author Tsemaye
 *
 */
public class AirplaneType {
	private Integer airplaneID, capacity;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airplaneID;
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
		AirplaneType other = (AirplaneType) obj;
		if (airplaneID != other.airplaneID)
			return false;
		return true;
	}

	public int getAirplaneID() {
		return airplaneID;
	}

	public void setAirplaneID(int airplaneID) {
		this.airplaneID = airplaneID;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

}
