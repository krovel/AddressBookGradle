package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;


public class AddressBookIOTest {
   /*  
	@Test
	public void givenContactInFileShouldRead() {
		AddressBookIO AddressBookIO = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		contactList = AddressBookIO.readData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}
	
	@Test
	public void writeContactToFile() {
		AddressBookIO AddressBookIO = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		Contact contact1 = new Contact("Kashif", "Ansari", "lucknow", "lucknow", "UP", "123456", "9876543210", "kashaf@hotmail.co.in");
		Contact contact2 = new Contact("Abdul", "Qadir", "Lucknow", "Lucknow", "UP", "654987", "9876543210", "aqaasa@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		AddressBookIO.writeData(contactList);
		Assert.assertEquals(2, AddressBookIO.countEntries());
	}
	*/
	@Test
	public void givenContactFromCSVFileShouldRead() {
		AddressBookIO AddressBookIO = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		contactList = AddressBookIO.readCSVData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}
	
	@Test
	public void writeContactToCSVFile() {
		AddressBookIO AddressBookIO = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		Contact contact1 = new Contact("Kashif", "Ansari", "Chowk", "Lko", "UP", "226003", "9598252500", "kashif@gmail.com");
		Contact contact2 = new Contact("Abdul", "Kalam", "Add", "Allahabad", "UP", "190006", "9876543102", "kalam@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		boolean b = AddressBookIO.writeCSVData(contactList);
		Assert.assertTrue(b);
	}
}