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
			break;
		case 2:
			name = new StringBuffer("ADMINISTRATOR");
			break;
		case 3:
			name = new StringBuffer("TRAVELER");
			break;
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name.toString();
	}
	
	
	
	
}
