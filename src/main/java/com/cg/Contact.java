package com.cg;

public class Contact {
	
	private String firstName, lastName, address, city, state, zip, phoneNo, email;
	
	ValidateContact validate = new ValidateContact();

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
	     boolean b = validate.validateFirstName(firstName);
	    if(b)
		this.firstName = firstName;
	    else
	    	System.out.println("Error! Enter first name again-");
		return b;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		 boolean b = validate.validateLastName(lastName);
		    if(b)
			this.lastName = lastName;
		    else
		    	System.out.println("Error! Enter last name again-");
			return b;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		 boolean b = validate.validateAddress(address);
		    if(b)
			this.address = address;
		    else
		    	System.out.println("Error! Enter address again-");
			return b;
	}

	public String getCity() {
		return city;
	}

	public boolean setCity(String city) {
		 boolean b = validate.validateCity(city);
		    if(b)
			this.city = city;
		    else
		    	System.out.println("Error! Enter city again-");
			return b;
	}

	public String getState() {
		return state;
	}

	public boolean setState(String state) {
		 boolean b = validate.validateState(state);
		    if(b)
			this.state = state;
		    else
		    	System.out.println("Error! Enter state again-");
			return b;
	}

	public String getZip() {
		return zip;
	}

	public boolean setZip(String zip) {
		 boolean b = validate.validateZip(zip);
		    if(b)
			this.zip = zip;
		    else
		    	System.out.println("Error! Enter zip again-");
			return b;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public boolean setPhoneNo(String phoneNo) {
		 boolean b = validate.validatePhoneNo(phoneNo);
		    if(b)
			this.phoneNo = phoneNo;
		    else
		    	System.out.println("Error! Enter phone no again-");
			return b;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		 boolean b = validate.validateEmail(email);
		    if(b)
			this.email = email;
		    else
		    	System.out.println("Error! Enter email again-");
			return b;
	}

	@Override
	public String toString() {
		return "First Name :" + firstName + "\nLast Name :" + lastName + "\nAddress :" + address + "\nCity :" + city
				+ "\nState :" + state + "\nZip :" + zip + "\nPhone No :" + phoneNo + "\nEmail :" + email;
	}
}