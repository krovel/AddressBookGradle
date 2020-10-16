package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;


public class AddressBookIOTest {
     
	@Test
	public void givenContactsInFileShouldRead() {
		AddressBookIO addressBookFileIOService = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		contactList = addressBookFileIOService.readData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}
	
	@Test
	public void writeContactsToFile() {
		AddressBookIO addressBookFileIOService = new AddressBookIO();
		List<Contact> contactList = new ArrayList<>();
		Contact contact1 = new Contact("Kashif", "Ansari", "lucknow", "lucknow", "UP", "123456", "9876543210", "kashaf@hotmail.co.in");
		Contact contact2 = new Contact("Abdul", "Qadir", "Lucknow", "Lucknow", "UP", "654987", "9876543210", "aqaasa@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		addressBookFileIOService.writeData(contactList);
		Assert.assertEquals(2, addressBookFileIOService.countEntries());
	}
}