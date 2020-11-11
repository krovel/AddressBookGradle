package com.cg;

import com.opencsv.bean.CsvBindByName;
import java.time.LocalDate;
import java.util.Objects;

public class Contact {
	@CsvBindByName
	private String firstName;

	@CsvBindByName
	private String lastName;

	@CsvBindByName
	private String address;

	@CsvBindByName
	private String city;

	@CsvBindByName
	private String state;

	@CsvBindByName
	private String zip;


	@CsvBindByName(column = "PhoneNumber")
	private String phoneNo;

	@CsvBindByName
	private String email;
	
	private LocalDate dateAdded;

	private String type;

	private String bookName;

	private int id;

	public Contact() {

	}

	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNo, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
	}
	
	public Contact(int id, String firstName, String lastName, String address, String city, String state, String zip, LocalDate dateAdded,
			String phoneNo, String email, String type, String bookName) {
		this(firstName, lastName, address,city,state, zip, phoneNo, email);
		this.setId(id);
		this.setDateAdded(dateAdded);
		this.setCity(city);
		this.setState(state);
		this.setType(type);
		this.setBookName(bookName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	} 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateFirstName(firstName);
		if (b)
			this.firstName = firstName;
		else
			System.out.println("Enter First Name again");
		return b;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateLastName(lastName);
		if (b)
			this.lastName = lastName;
		else
			System.out.println("Enter Last Name again");
		return b;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateAddress(address);
		if (b)
			this.address = address;
		else
			System.out.println("Enter Address again");
		return b;
	}

	public String getCity() {
		return city;
	}

	public boolean setCity(String city) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateCity(city);
		if (b)
			this.city = city;
		else
			System.out.println("Enter City again");
		return b;
	}

	public String getState() {
		return state;
	}

	public boolean setState(String state) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateState(state);
		if (b)
			this.state = state;
		else
			System.out.println("Enter State again");
		return b;
	}

	public String getZip() {
		return zip;
	}

	public boolean setZip(String zip) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateZip(zip);
		if (b)
			this.zip = zip;
		else
			System.out.println("Enter Zip again");
		return b;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public boolean setPhoneNo(String phoneNo) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validatePhoneNo(phoneNo);
		if (b)
			this.phoneNo = phoneNo;
		else
			System.out.println("Enter Phone No again");
		return b;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		ValidateContact validateContact = new ValidateContact();
		boolean b = validateContact.validateEmail(email);
		if (b)
			this.email = email;
		else
			System.out.println("Enter Email again");
		return b;
	}

	@Override
	public String toString() {
		return "FirstName : " + firstName + " LastName : " + lastName + " Address : " + address + " City : " + city
				+ " State : " + state + " Zip : " + zip + " Phone No : " + phoneNo + " Email : " + email;
	}
	@Override
	public boolean equals(Object obj) {		
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Contact that = (Contact) obj;
		return firstName.equals(that.firstName) && phoneNo.equals(that.phoneNo) && lastName.equals(that.lastName);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

}