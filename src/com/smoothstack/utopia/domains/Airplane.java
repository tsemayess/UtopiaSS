package com.smoothstack.utopia.domains;

public class Airplane {
	private Integer airplaneID;
	Integer type;
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	public int getAirplaneID() {
		return airplaneID;
	}
	public void setAirplaneID(int airplaneID) {
		this.airplaneID = airplaneID;
	}
	
	
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
		Airplane other = (Airplane) obj;
		if (airplaneID != other.airplaneID)
			return false;
		return true;
	}
	
}
