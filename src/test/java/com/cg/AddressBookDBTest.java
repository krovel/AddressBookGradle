package com.cg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class AddressBookDBTest {

	private AddressBookDBService addressBookDBService;

	@Before
	public void initialize() {
		addressBookDBService = new AddressBookDBService();
	}

	@Test
	public void givenAddressBookDB_ShouldMatchCount() throws AddressBookDBException {
		List<Contact> contactList = addressBookDBService.readContacts();
		Assert.assertEquals(4, contactList.size());
	}
}