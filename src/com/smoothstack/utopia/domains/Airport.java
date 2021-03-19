package com.smoothstack.utopia.domains;

public class Airport {
	private StringBuffer airportCode, city;
	
	public String getAirportCode() {
		return airportCode.toString();
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = new StringBuffer(airportCode);
	}
	public String getCity() {
		return city.toString();
	}
	public void setCity(String city) {
		this.city = new StringBuffer(city);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
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
		Airport other = (Airport) obj;
		if (airportCode == null) {
			if (other.airportCode != null)
				return false;
		} else if (!airportCode.equals(other.airportCode))
			return false;
		return true;
	}
}
