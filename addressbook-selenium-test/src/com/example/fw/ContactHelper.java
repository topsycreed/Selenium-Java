package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void returnToHomePage() {
		click(By.linkText("home"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.home2);
	}

	public void goToAddingContact() {
		click(By.linkText("add new"));
	}
	
	private void selectContactByIndex(int index) {
		index++;
		click(By.xpath("//tr["+index+"]/td[7]/a/img"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("//input[@value='Delete']"));
	}
}
