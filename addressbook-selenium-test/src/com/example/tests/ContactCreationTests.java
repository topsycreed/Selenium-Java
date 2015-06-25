package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.ContactDataGenerator.loadContactFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

	public class ContactCreationTests extends TestBase	
	{
		@DataProvider
		public Iterator<Object[]>contactsFromFile() throws IOException{
			return wrapContactsForDataProvider(loadContactsFromXmlFile (new File("contacts.xml"))).iterator();
		}
		
		@Test(dataProvider="contactsFromFile")	
		public void testValidContactCreation(ContactData contacts) throws Exception {

	    // save old
	     SortedListOf<ContactData> oldList=app.getContactHelper().getContacts();

	     app.getContactHelper().createContacts(contacts);

	    // save new
	     SortedListOf<ContactData> newList=app.getContactHelper().getContacts(); 
	    
	     //compare  
	     assertThat(newList,equalTo(oldList.withAdded(contacts)));
	  }
}
