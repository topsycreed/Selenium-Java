package com.example.tests;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //action
	    app.getGroupHelper().initGroupCreation();
	  	app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	    //save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //merge states
	    assertEquals(newList.size(), oldList.size()+1);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	  }
}