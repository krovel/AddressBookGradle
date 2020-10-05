/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.cg;

import org.junit.*;

public class AddressBookTest {
	 @Test
	    public void firstNameTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateFirstName("Kashif"));
	 } 
	 @Test
	    public void lastNameTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateLastName("Ansari"));
	 }
	 @Test
	    public void emailTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateEmail("kashif.ansari@gmail.com"));
	 }
	 @Test
	    public void phoneNoTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validatePhoneNo("1234567890"));
	 }
	 @Test
	    public void addressTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateAddress("Lko"));
	 }
	 @Test
	    public void cityTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateCity("Lucknow"));
	 }
	 @Test
	    public void stateTest() {
	        ValidateContact contact = new ValidateContact();
	        Assert.assertTrue(contact.validateState("UttarPradesh"));
	 }
}