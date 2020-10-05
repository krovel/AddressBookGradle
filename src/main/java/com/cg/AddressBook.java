package com.cg;

import java.util.*;

public class AddressBook {
	Scanner in = new Scanner(System.in);
	private ArrayList<Contact> contactList = new ArrayList<>();
	Map<String, Contact> contactMap = new HashMap<>();
	static Map<String, AddressBook> addressBookList = new TreeMap<>();
	
	public void addNewContact() {
		boolean b = false;
		Contact contact = new Contact();
		System.out.print("Enter first name- ");
		while(!b) {
		b = contact.setFirstName(in.next());
		}
		b = false;
		System.out.print("Enter last name- ");
		while(!b) {
		b = contact.setLastName(in.next());
		}
		b = false;
		System.out.print("Enter address- ");
		while(!b) {
		b = contact.setAddress(in.next());
		}
		b = false;
		System.out.print("Enter city- ");
		while(!b) {
		b = contact.setCity(in.next());
		}
		b = false;
		System.out.print("Enter state- ");
		while(!b) {
		b = contact.setState(in.next());
		}
		b = false;
		System.out.print("Enter zip- ");
		while(!b) {
		b = contact.setZip(in.next());
		}
		b = false;
		System.out.print("Enter phone number- ");
		while(!b) {
		b = contact.setPhoneNo(in.next());
		}
		b = false;
		System.out.print("Enter email- ");
		while(!b) {
		b = contact.setEmail(in.next());
		}
		String name = contact.getFirstName()+" "+contact.getLastName();
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("Error! Name already present.\n");
		}else {
			contactList.add(contact);
		contactMap.put(name, contact);
		}
	}
	
	public void editContact(String firstName, String lastName) {
		String name = firstName+" "+lastName;
		boolean b = false;
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("What do you want to edit?");
			String s = in.next().toLowerCase();
			switch (s) {
			case ("address"):
				System.out.println("Enter address-");
			while(!b) {
				b = contactMap.get(name).setAddress(in.next());
			}
				break;
			case ("city"):
				System.out.println("Enter city-");
			while(!b) {
				b = contactMap.get(name).setCity(in.next());
			}
				break;
			case ("state"):
				System.out.println("Enter state-");
			while(!b) {
				b = contactMap.get(name).setState(in.next());
			}
				break;
			case ("zip"):
				System.out.println("Enter zip-");
			while(!b) {
				b = contactMap.get(name).setZip(in.next());
			}
				break;
			case ("phoneno"):
				System.out.println("Enter phone no-");
			while(!b) {
				b = contactMap.get(name).setPhoneNo(in.next());
			}
				break;
			case ("email"):
				System.out.println("Enter email-");
			while(!b) {
				b = contactMap.get(name).setEmail(in.next());
			}
				break;
			}
		} else {
			System.out.println("Error! Name already present.");
		}
	}

	public void display() {
		if (contactList.size() == 0)
			System.out.println("No contacts to show");
			for (int i = 0; i < contactList.size(); i++) {
				Contact contact = contactList.get(i);
				System.out.println("\nContact :" + (i + 1));
				System.out.println(contact);
			}
	}
}