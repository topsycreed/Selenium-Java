package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group)throws Exception
	{
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupPage();
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    Random rnd = new Random(); 
	    int index = rnd.nextInt(oldList.size()-1);
	    //actions
	    app.getGroupHelper().initGroupModification(index+1);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
		 // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //merge states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList); //
	    Collections.sort(newList);//
	    assertEquals(newList,oldList); 
	}
}