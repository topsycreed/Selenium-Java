package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationsTests extends TestBase{
	
	  @Test(dataProvider = "randomValidContactGenerator")
	  public void testContactModifications(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		List<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1); 
		app.getContactHelper().openEditPage(index);
		app.getContactHelper().fillContactDetails(contact);
		app.getContactHelper().updateContactCreation();
		app.getContactHelper().returnToMainPage();
		 // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    //merge states
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList); //
	    //Collections.sort(newList);//
	    assertEquals(newList,oldList); 
	  }
}