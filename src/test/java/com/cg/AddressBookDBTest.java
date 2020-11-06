package com.cg;

import java.util.List;
import org.junit.Test;
import java.time.LocalDate;
import org.junit.Assert;

import com.cg.AddressbookService.IOService;

public class AddressBookDBTest {
	
	@Test
	public void givenAddressBookInDB_WhenRetrived_ShouldMatchContactCount() {
		AddressbookService addressBookService = new AddressbookService();
		List<Contact> addressBookData = addressBookService.readAddressBookData(IOService.DB_IO);
		Assert.assertEquals(5, addressBookData.size());
	}
	@Test
	public void givenAddressBookInDB_WhenUpdated_ShouldBeInSyncWithDB() {
		AddressbookService addressBookService = new AddressbookService();
		addressBookService.updateAddressBookData("Kashif",98589);
		boolean result = addressBookService.checkAddressbookInSyncWithDB("Kashif");
		Assert.assertTrue(result);
	}
	@Test
	public void givenDateRange_WhenRetrieved_ShouldMatchContactCount() {
		AddressbookService addressBookService = new AddressbookService();
		addressBookService.readAddressBookData(IOService.DB_IO);
		LocalDate startDate = LocalDate.of(2018,01,01);
		LocalDate endDate = LocalDate.now();
		List<Contact> addressBookData = addressBookService.readAddressBookForDateRange(IOService.DB_IO, startDate, endDate);
		Assert.assertEquals(5, addressBookData.size());
	}

	@Test
	public void givenAddressBookDB_WhenRetrivedBasedOnCity_ShouldReturnCount() throws AddressBookDBException {
		AddressBookDBService addressBookService = new AddressBookDBService();
		int n = addressBookService.getNumberOfContactsInCity("city","Lucknow");
		Assert.assertEquals(1, n);
	}
	@Test
	public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
		AddressbookService addressBookService = new AddressbookService();
		addressBookService.readAddressBookData(IOService.DB_IO);
		addressBookService.addContactToAddressBook(IOService.DB_IO,5,"Swati","Verma","IIM","LKO","UP",22656,8494949,"@gmail.com",LocalDate.of(2019,8,19),"Lko","UP","Friend","B");
		boolean result = addressBookService.checkAddressbookInSyncWithDB("Vaishali");
		Assert.assertTrue(result);
	}
}