package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

	public class ContactCreationTests extends TestBase
	
	{
	  @Test(dataProvider="randomValidContactGenerator")
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
