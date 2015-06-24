package com.example.tests;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().goToNewContactPage();
	//action
	app.getContactHelper().fillContactDetails(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToMainPage();

    List<ContactData> newList = app.getContactHelper().getContacts();

    // merge states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
   }
}