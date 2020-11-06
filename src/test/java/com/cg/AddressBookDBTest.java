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
		Assert.assertEquals(4, addressBookData.size());
	}
	public void givenAddressBookInDB_WhenUpdated_ShouldBeInSyncWithDB() {
		AddressbookService addressBookService = new AddressbookService();
		addressBookService.updateAddressBookData("Kashif",950659);
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
		Assert.assertEquals(4, addressBookData.size());
	}
}