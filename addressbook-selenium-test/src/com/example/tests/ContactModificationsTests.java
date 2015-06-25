package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationsTests extends TestBase{

	@DataProvider
	public Iterator<Object[]>contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile (new File("contact.xml"))).iterator();
	}

	@Test(dataProvider="contactsFromFile")	
	public void modifyContact(ContactData contacts){

	 // save old
	 SortedListOf<ContactData> oldList=app.getContactHelper().getContacts();
    Random rnd =new Random();
    int index= rnd.nextInt(oldList.size()-1);
	
	app.getContactHelper().modifySomeContact(index,contacts);

	// save new
	 SortedListOf<ContactData> newList=app.getContactHelper().getContacts(); 
    
    //compare
	 assertThat(newList,equalTo(oldList.without(index).withAdded(contacts)));
   }
}	