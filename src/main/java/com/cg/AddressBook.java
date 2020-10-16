package com.cg;

import java.util.*;

import java.util.stream.Collectors;

public class AddressBook {
	Scanner in = new Scanner(System.in);
	static LinkedList<Contact> ContactsList = new LinkedList<>();
	Map<String, Contact> ContactsMap = new TreeMap<>();
	
	public AddressBook() {
		ContactsMap = new TreeMap<>();
	}
	public Map<String, Contact> getContactsMap() {
		return ContactsMap;
	}
	
	public void addNewContacts() {
		boolean b = false;
		Contact Contacts = new Contact();
		System.out.print("Enter first name- ");
		while(!b) {
		b = Contacts.setFirstName(in.next());
		}
		b = false;
		System.out.print("Enter last name- ");
		while(!b) {
		b = Contacts.setLastName(in.next());
		}
		b = false;
		System.out.print("Enter address- ");
		while(!b) {
		b = Contacts.setAddress(in.next());
		}
		b = false;
		System.out.print("Enter city- ");
		while(!b) {
		b = Contacts.setCity(in.next());
		}
		b = false;
		System.out.print("Enter state- ");
		while(!b) {
		b = Contacts.setState(in.next());
		}
		b = false;
		System.out.print("Enter zip- ");
		while(!b) {
		b = Contacts.setZip(in.next());
		}
		b = false;
		System.out.print("Enter phone number- ");
		while(!b) {
		b = Contacts.setPhoneNo(in.next());
		}
		b = false;
		System.out.print("Enter email- ");
		while(!b) {
		b = Contacts.setEmail(in.next());
		}
		String name = Contacts.getFirstName()+" "+Contacts.getLastName();
		Boolean keyPresent = ContactsMap.containsKey(name);
		if (keyPresent) {
			System.out.println("Error! Name already present.\n");
		}else {
		ContactsMap.put(name, Contacts);
		ContactsList.add(Contacts);
		}
	}
	
	public void editContacts() {
		System.out.println("Enter first name-");
    	String firstName = in.next();
    	System.out.println("Enter last name-");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		boolean b = false;
		Boolean keyPresent = ContactsMap.containsKey(name);
		if (keyPresent) {
			System.out.println("What do you want to edit?");
			String s = in.next().toLowerCase();
			switch (s) {
			case ("address"):
				System.out.println("Enter address-");
			while(!b) {
				b = ContactsMap.get(name).setAddress(in.next());
			}
				break;
			case ("city"):
				System.out.println("Enter city-");
			while(!b) {
				b = ContactsMap.get(name).setCity(in.next());
			}
				break;
			case ("state"):
				System.out.println("Enter state-");
			while(!b) {
				b = ContactsMap.get(name).setState(in.next());
			}
				break;
			case ("zip"):
				System.out.println("Enter zip-");
			while(!b) {
				b = ContactsMap.get(name).setZip(in.next());
			}
				break;
			case ("phoneno"):
				System.out.println("Enter phone no-");
			while(!b) {
				b = ContactsMap.get(name).setPhoneNo(in.next());
			}
				break;
			case ("email"):
				System.out.println("Enter email-");
			while(!b) {
				b = ContactsMap.get(name).setEmail(in.next());
			}
				break;
			}
		} else {
			System.out.println("This name is not present.");
		}
	}
	
	public void display() {
		if(ContactsMap.size() == 0)
			System.out.println("No Contactss to show");
		else {
			Set set = ContactsMap.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println(entry.getValue());
			}
		}
	}
	public void deleteContacts() {
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		Boolean keyPresent = ContactsMap.containsKey(name);
		if (keyPresent) {
			ContactsMap.remove(name);
			Contact c = ContactsMap.get(name);
			ContactsList.remove(c);
		} else {
			System.out.println("This name is not present.");
		}
	}
	public List<Contact> searchPersonsByCity(String city) {
		return ContactsList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
	}

	public List<Contact> searchPersonsByState(String state) {
		return ContactsList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}
	public int countPersonsByCity(String city) {
		return ContactsList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList()).size();
	}

	public int countPersonsByState(String state) {
		return ContactsList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList()).size();
	}
	
	public List<Contact> sortPersonsByCity() {
		return ContactsList.stream().sorted((n1, n2) -> n1.getCity().compareTo(n2.getCity())).collect(Collectors.toList());
	}
	
	public List<Contact> sortPersonsByState() {
		return ContactsList.stream().sorted((n1, n2) -> n1.getState().compareTo(n2.getState())).collect(Collectors.toList());
	}
	
	public List<Contact> sortPersonsByZip() {
		return ContactsList.stream().sorted((n1, n2) -> n1.getZip().compareTo(n2.getZip())).collect(Collectors.toList());
	}
}