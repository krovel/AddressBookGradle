package com.cg;

import java.util.*;

import java.util.stream.Collectors;

public class AddressBookList {
	Scanner in = new Scanner(System.in);
	Map<String, AddressBook> addressBookMap = new TreeMap<>();
	 ArrayList<AddressBook> addressList = new ArrayList<>();
	 
	 public AddressBookList() {
			addressBookMap = new TreeMap<>();
		}
	 public Map<String, AddressBook> getAddressBookMap() {
			return addressBookMap;
  }
  public void openAddressBook() {
	  System.out.println("Enter name of addressbook-");
	  String bookName = in.next();
	  boolean keyPresent = addressBookMap.containsKey(bookName);
	  if(keyPresent) {
		  AddressBook addressbook = addressBookMap.get(bookName);
	  System.out.println("1. Add contact");
      System.out.println("2. Edit contact");
      System.out.println("3. View addressbook details");
      System.out.println("4. Delete contact");
      System.out.println("5. Exit");
      int option = in.nextInt();
      while(option!= 5) {
    	  if(option == 1)
    		  addressbook.addNewContact();
    	  else if(option == 2) 
    		  addressbook.editContact();
    	  else if (option == 3)
    		  addressbook.display();
    	  else if(option == 4) 
    		  addressbook.deleteContact();
    	  else if(option == 5)
    		  break;
    	  else{
      		System.out.println("Error! Enter correct choice-");    
      	}
      	System.out.println("Enter choice again (1. Add contact, 2. Edit Contact, 3. View address details, 4. Delete contact, 5. Exit)-");
      	option = in.nextInt();
      }
  }
	  else {
		 System.out.println("Address Book does not exist."); 
	  }
  }
  public void newAddressBook() {
	  AddressBook addressBook = new AddressBook();
	  System.out.println("Enter the name of address book-");
	  String bookName = in.next();
	  boolean keyPresent = addressBookMap.containsKey(bookName);
	  if(keyPresent)
		  System.out.println("Already Present.");
	  else
		  addressBookMap.put(bookName, addressBook);
		}
  public void showDetails() {
	  if(addressBookMap.size() == 0)
		  System.out.println("No Address Book is present");
	  else {
		  Set set = addressBookMap.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				System.out.println("---------------");
				System.out.println("Address Book : " + entry.getKey());
				entry.getValue();
				((AddressBook) entry.getValue()).display();
		  }
	  }
  }
}