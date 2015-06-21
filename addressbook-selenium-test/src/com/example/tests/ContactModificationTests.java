package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifyContact(){
		app.getNavagationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);   
		ContactData contacts = new ContactData();
	    contacts.firstname="Gena";
	    contacts.lastname="Chursov";
	    contacts.bmonth="June";
	    app.getContactHelper().fillContactForm(contacts);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
   }
}	