package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationsTests extends TestBase{

	@Test(dataProvider="randomValidContactGenerator")
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