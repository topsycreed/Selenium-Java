package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testNonEmptyContactCreated() throws Exception {
	app.getNavagationHelper().openMainPage();
	app.getContactHelper().goToAddingContact();
    ContactData contact = new ContactData();
    contact.firstname = "First name 1";
    contact.lastname = "Last name 1";
    contact.address = "Address 1";
    contact.home = "Home 1";
    contact.mobile = "Mobile 1";
    contact.work = "Work 1";
    contact.email = "E-mail 1";
    contact.email2 = "E-mail2 1";
    contact.bday = "1";
    contact.bmonth = "January";
    contact.byear = "2000";
    contact.address2 = "Address Sec 1";
    contact.home2 = "Home Sec 1";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  @Test
  public void testEmptyContactCreated() throws Exception {
	app.getNavagationHelper().openMainPage();
	app.getContactHelper().goToAddingContact();
    ContactData contact = new ContactData();
    contact.firstname = "";
    contact.lastname = "";
    contact.address = "";
    contact.home = "";
    contact.mobile = "";
    contact.work = "";
    contact.email = "";
    contact.email2 = "";
    contact.bday = "-";
    contact.bmonth = "-";
    contact.byear = "-";
    contact.address2 = "";
    contact.home2 = "";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
