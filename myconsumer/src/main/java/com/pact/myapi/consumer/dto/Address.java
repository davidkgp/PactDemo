package com.pact.myapi.consumer.dto;

public class Address {
	
	private String addressLine1;
	
	private String addressLine2;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressLine1, String addressLine2) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.addressLine1.equals(((Address)obj).addressLine1) && this.addressLine2.equals(((Address)obj).addressLine2);
	}
	
	
	
	
	
	
}
