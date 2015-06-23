package com.example.tests;

import java.util.*;

import  static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test(dataProvider="randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavagationHelper().openMainPage();
    app.getNavagationHelper().gotoGroupsPage();
    
    // save old
    List<GroupData> oldList=app.getGroupHelper().getGrous();
    
    app.getGroupHelper().initGroupCreation();

	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new
    List<GroupData> newList=app.getGroupHelper().getGrous(); 
   
    //compare
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList,oldList);
   }
}