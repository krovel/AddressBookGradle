package com.cg;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.cg.AddressbookService.IOService;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.*;

public class AddressBookJsonServerTest {

	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
	}

	private Contact[] getContactList() {
		Response response = RestAssured.get("/addressBook");
		System.out.println("CONTACTS IN JSONServer:\n"+response.asString());
		Contact[] arrayOfEmps = new Gson().fromJson(response.asString(),Contact[].class);
		return arrayOfEmps;
	}

	private Response addContactToJsonServer(Contact contact) {
		String contactJson = new Gson().toJson(contact);
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		request.body(contactJson);
		return request.post("/addressBook");
	}

	@Test
	public void givenNewContact_WhenAdded_ShouldMatch201ResponseCount() {
		Contact[] arrayOfContacts = getContactList();
		AddressbookService addressBookDataService;
		addressBookDataService = new AddressbookService(Arrays.asList(arrayOfContacts));

		Contact contact = null;
		contact = new Contact(0, "Kashif", "Ansari","Chowk","Lucknow","UP","226003","9598252500","krovel096@gmail.com");

		Response response = addContactToJsonServer(contact);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);

		contact = new Gson().fromJson(response.asString(), Contact.class);
		addressBookDataService.addContactToAddressBook(contact, IOService.REST_IO);
		long entries = addressBookDataService.countEntries(IOService.REST_IO);
		Assert.assertEquals(2, entries);
	}

	@Test 
	public void givenContactsInJSONServer_WhenRetrieved_ShouldMatchTheCount() {
		Contact[] arrayContacts = getContactList();
		AddressbookService addressBookDataService;
		addressBookDataService = new AddressbookService(Arrays.asList(arrayContacts));
		long entries = addressBookDataService.countEntries(IOService.REST_IO);
		Assert.assertEquals(2, entries);
	}
	//UC23
	@Test
	public void givenMultipleContacts_WhenAdded_ShouldMatch201ResponseCount() {
		Contact[] arrContacts = getContactList();
		AddressbookService addressBookDataService;
		addressBookDataService = new AddressbookService(Arrays.asList(arrContacts));

		Contact[] arrayOfContacts = {
				new Contact(0,"Raunak","MK", "Anand Vihar","Lko","Uttar Pradesh","456555","9030303","jdksj@gmail.com"),
				new Contact(0, "Vimal","G","RS Colony","Guntur","Andhra Pradesh","408223","49949943","sjksjda@gmail.com"),
				new Contact(0, "Paras", "M","New town","Vadodra","Gujarat","509001","3888393","dkakjsj@gmail.com"),
		};

		for(Contact contact :arrayOfContacts) {
			Response response = addContactToJsonServer(contact);
			int statusCode = response.getStatusCode();
			Assert.assertEquals(201, statusCode);

			contact = new Gson().fromJson(response.asString(), Contact.class);
			addressBookDataService.addContactToAddressBook(contact, IOService.REST_IO);
		}

		long entries = addressBookDataService.countEntries(IOService.REST_IO);
		Assert.assertEquals(5, entries);
	}
	//UC24
	@Test 
	public void givenNewPhoneNumberForContact_WhenUpdated_ShouldMatch200Response() {
		AddressbookService addressBookDataService;
		Contact[] arrayOfContacts = getContactList();
		System.out.println(arrayOfContacts[0]);
		addressBookDataService = new AddressbookService(Arrays.asList(arrayOfContacts));

		addressBookDataService.updateAddressBookJson("Raunak", 9999999);
		Contact contact = addressBookDataService.getAddressBookData("Rohith");

		String contactJson = new Gson().toJson(contact);
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		request.body(contactJson);
		Response response = request.put("/addressbook_service/"+contact.getId());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	@Test 
	public void givenContactToDelete_WhenDeleted_ShouldMatch200ResponseAndCount() {
		AddressbookService addressBookDataService;
		Contact[] arrayOfContacts = getContactList();
		addressBookDataService = new AddressbookService(Arrays.asList(arrayOfContacts));
		
		Contact contact = addressBookDataService.getAddressBookData("Anil");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		Response response = request.delete("/addressbook_service/"+contact.getId());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
		addressBookDataService.deleteContact(contact.getFirstName(),IOService.REST_IO);
		long entries = addressBookDataService.countEntries(IOService.REST_IO);
		Assert.assertEquals(4, entries);
	}
	
}