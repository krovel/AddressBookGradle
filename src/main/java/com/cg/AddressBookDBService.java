package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AddressBookDBService {

	private Connection getConnection() throws AddressBookDBException {
		String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service";
		String userName = "root";
		String password = "Matrixkashif@1";
		try {
			return DriverManager.getConnection(jdbcURL, userName, password);
		} catch (SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
	}

	public List<Contact> readContacts() throws AddressBookDBException {
		// TODO Auto-generated method stub
		String sql = "Select * from person_details;";
		List<Contact> contactList = new ArrayList<Contact>();
		try(Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			contactList = getContactData(result);
		}catch(SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
		return contactList;
	}

	private List<Contact> getContactData(ResultSet result) throws AddressBookDBException{
		List<Contact> contactList = new ArrayList<Contact>();
		try {
			while(result.next()) {
				String firstName = result.getString("firstname");
				String lastName = result.getString("lastname");
				String address = result.getString("street");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phoneNo = result.getString("phone");
				String email = result.getString("email");
				contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNo, email));
			}
		}catch(SQLException e) {
			throw new AddressBookDBException(AddressBookDBException.ExceptionType.CONNECTION_ERROR, e.getMessage());
		}
		return contactList;
		}	
}