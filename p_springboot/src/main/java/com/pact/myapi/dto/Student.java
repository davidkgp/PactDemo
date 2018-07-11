package com.pact.myapi.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private Address address;
	
	private List<Address> otherAddress;
	
	private Map<String,String> parentDetails;
	
	private Map<String,Friend> labParterDetails;

	public Student(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.parentDetails = new HashMap<String,String>();
		parentDetails.put("fatherName", "Dave Roger");
		parentDetails.put("motherName", "Teri Wig");
		
		this.otherAddress = Arrays.asList(new Address("My Temp Address11", "My Temp Address12")
				,new Address("My Temp Address21", "My Temp Address22")
				,new Address("My Temp Address31", "My Temp Address32"));
		
		this.labParterDetails = new HashMap<String,Friend>();
		labParterDetails.put("labPartner1", new Friend("Deb", "Laxman", new Address("Amta", "West Bengal")));
		labParterDetails.put("labPartner2", new Friend("Sanan", "Prakash", new Address("Hoogly", "West Bengal")));
		
		
	}
	
	
	
	

	/**
	 * @return the labParterDetails
	 */
	public Map<String, Friend> getLabParterDetails() {
		return labParterDetails;
	}





	/**
	 * @param labParterDetails the labParterDetails to set
	 */
	public void setLabParterDetails(Map<String, Friend> labParterDetails) {
		this.labParterDetails = labParterDetails;
	}





	/**
	 * @return the parentDetails
	 */
	public Map<String, String> getParentDetails() {
		return parentDetails;
	}



	/**
	 * @param parentDetails the parentDetails to set
	 */
	public void setParentDetails(Map<String, String> parentDetails) {
		this.parentDetails = parentDetails;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}





	public List<Address> getOtherAddress() {
		return otherAddress;
	}





	public void setOtherAddress(List<Address> otherAddress) {
		this.otherAddress = otherAddress;
	}
	
	
	
	
	
	
	
}
