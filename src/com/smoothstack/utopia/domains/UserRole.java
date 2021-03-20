package com.smoothstack.utopia.domains;

public class UserRole {
	private Integer iD;
	private StringBuffer name;
	/**
	 * @return the iD
	 */
	public int getiD() {
		return iD;
	}
	/**
	 * @param iD the iD to set
	 * @throws Exception 
	 */
	public void setiD(int iD) {
		 
		
		this.iD = iD;
		switch(iD) {
		case 1:
			name = new StringBuffer("EMPLOYEE");
		case 2:
			name = new StringBuffer("ADMINISTRATIVE");
		case 3:
			name = new StringBuffer("TRAVELER");
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name.toString();
	}
	
	
	
	
}
