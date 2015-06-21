
package com.example.tests;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

 @Test
public void deleteContact(){
	 app.getNavagationHelper().openMainPage();
     app.getContactHelper().deleteContact(1);
     app.getContactHelper().returnToHomePage();
     }
}