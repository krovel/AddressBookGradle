package com.cg;

import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class AddressbookService {
	
	public enum IOService {CONSOLE_IO, FILE_IO,DB_IO, REST_IO}
	private AddressBookDBService addressBookDBService;
	private List<Contact> addressBookList;
	
	public AddressbookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public List<Contact> readAddressBookData(IOService ioService) {
		if(ioService.equals(IOService.DB_IO)) {
			this.addressBookList = addressBookDBService.readContacts();
		}
		return this.addressBookList;
	}
	public void updateAddressBookData(String firstName, int phone) {
		int result = addressBookDBService.updateContactData(firstName, phone);
		if(result == 0) {
			return;
		}
		Contact contactData =this.getAddressBookData(firstName);
		if(contactData != null) {
			contactData.setPhoneNo(phone+"");;
		}
	}

	private Contact getAddressBookData(String firstName) {
		Contact contact;
		contact = this.addressBookList.stream()
					  .filter(con -> con.getFirstName().equals(firstName))
					  .findFirst()
					  .orElse(null);
		return contact;
	}

	public boolean checkAddressbookInSyncWithDB(String firstName) {
		List<Contact> addressBookList = addressBookDBService.getContactData(firstName);
		return addressBookList.get(0).equals(getAddressBookData(firstName));
	}
	public List<Contact> readAddressBookForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate) {
		if(ioService.equals(IOService.DB_IO)) {
			return addressBookDBService.getAddressBookForDateRange(startDate, endDate);
		}
		return null;
	}
	public void addContactToAddressBook(IOService ioService,int id, String firstName, String lastName, String address, String string, String string2, int zip, int phone,
			String email,LocalDate start, String city, String state, String type, String addressBookName) {
		addressBookList.add(addressBookDBService.addContactToAddressBook(id, firstName, lastName, address, zip, phone,
				 email, start, city, state, type, addressBookName));
	}
}