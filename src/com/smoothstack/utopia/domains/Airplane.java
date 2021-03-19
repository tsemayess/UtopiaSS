package com.smoothstack.utopia.domains;

public class Airplane {
	private Integer airplaneID;
	StringBuffer type;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type.toString();
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = new StringBuffer(type);
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
