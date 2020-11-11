package com.cg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public Object countEntries(IOService dbIo) {
		return addressBookList.size();
	}

	public void addContactsToAddressBookWithThreads(List<Contact> addressBList) {
		Map<Integer,Boolean> contactAdditionStatus = new HashMap<Integer,Boolean>();
		addressBList.forEach(contact->{
			Runnable task = () ->{
				contactAdditionStatus.put(contact.hashCode(), false);
				System.out.println("Contact Being Added: "+ Thread.currentThread().getName());
				this.addContactToAddressBook(IOService.DB_IO, contact.getId(), contact.getFirstName(), contact.getLastName(), 
										 contact.getAddress(), null, null, Integer.parseInt(contact.getZip()), Integer.parseInt(contact.getPhoneNo()), 
										 contact.getEmail(), contact.getDateAdded(), contact.getCity(), contact.getState(), contact.getType(), contact.getBookName());
				contactAdditionStatus.put(contact.hashCode(), true);
				System.out.println("Employee Added "+Thread.currentThread().getName());
			};
			Thread thread = new Thread(task, contact.getFirstName());
			thread.start();
		});
		while (contactAdditionStatus.containsValue(false)) {
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {

			}
		}
	}
}