package com.cg;

import java.util.List;

import org.junit.Test;

import com.cg.AddressbookService.IOService;

import org.junit.Assert;

public class AddressBookDBTest {
	
	@Test
	public void givenAddressBookInDB_WhenRetrived_ShouldMatchContactCount() {
		AddressbookService addressBookService = new AddressbookService();
		List<Contact> addressBookData = addressBookService.readAddressBookData(IOService.DB_IO);
		Assert.assertEquals(4, addressBookData.size());
	}
	public void givenEmployeePayrollInDB_WhenUpdated_ShouldBeInSyncWithDB() {
		AddressbookService addressBookService = new AddressbookService();
		addressBookService.updateAddressBookData("Kashif",950659);
		boolean result = addressBookService.checkAddressbookInSyncWithDB("Kashif");
		Assert.assertTrue(result);
	}
}