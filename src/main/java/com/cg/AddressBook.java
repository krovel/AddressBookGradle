package com.cg;

import java.util.*;

import java.util.stream.Collectors;

public class AddressBook {
	Scanner in = new Scanner(System.in);
	static LinkedList<Contact> contactList = new LinkedList<>();
	Map<String, Contact> contactMap = new TreeMap<>();
	
	public AddressBook() {
		contactMap = new TreeMap<>();
	}
	public Map<String, Contact> getContactMap() {
		return contactMap;
	}
	
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
		contactMap.put(name, contact);
		contactList.add(contact);
		}
	}
	
	public void editContact() {
		System.out.println("Enter first name-");
    	String firstName = in.next();
    	System.out.println("Enter last name-");
    	String lastName = in.next();
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
			System.out.println("This name is not present.");
		}
	}
	
	public void display() {
		if(contactMap.size() == 0)
			System.out.println("No contacts to show");
		else {
			Set set = contactMap.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println(entry.getValue());
			}
		}
	}
	public void deleteContact() {
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			contactMap.remove(name);
			Contact c = contactMap.get(name);
			contactList.remove(c);
		} else {
			System.out.println("This name is not present.");
		}
	}
	public List<Contact> searchPersonsByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
	}

	public List<Contact> searchPersonsByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}
	public int countPersonsByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList()).size();
	}

	public int countPersonsByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList()).size();
	}
}