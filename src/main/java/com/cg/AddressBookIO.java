package com.cg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIO {

	public static String Contacts_FILE_NAME = "contactsfile.txt";
	public static String Contacts_SECOND_FILE_NAME = "contactsfile2.txt";

	public List<Contact> readData() {
		List<Contact> ContactssList = new ArrayList<>();
		try {
			Files.lines(new File(Contacts_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,:]+");

				Contact Contacts = new Contact();
				Contacts.setFirstName(words[1]);
				Contacts.setLastName(words[3]);
				Contacts.setAddress(words[5]);
				Contacts.setCity(words[7]);
				Contacts.setState(words[9]);
				Contacts.setZip(words[11]);
				Contacts.setPhoneNo(words[13]);
				Contacts.setEmail(words[15]);

				ContactssList.add(Contacts);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ContactssList;
	}

	public void writeData(List<Contact> ContactsList) {
		StringBuffer empBuffer = new StringBuffer();
		ContactsList.forEach(Contacts -> {
			String employeeDataString = Contacts.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(Contacts_SECOND_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(Contacts_SECOND_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}