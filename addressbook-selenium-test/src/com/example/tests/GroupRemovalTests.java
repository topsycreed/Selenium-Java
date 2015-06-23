package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.*;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	
	@Test
	public void deleteSomeGroup() {
		app.getNavagationHelper().openMainPage();
		app.getNavagationHelper().gotoGroupsPage();
		
	    // save old
	    List<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	    Random rnd =new Random();
	    int index=rnd.nextInt(oldList.size()-1);
	     
	    //actions
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupsPage();
		
	    // save new
	    List<GroupData> newList=app.getGroupHelper().getGrous(); 
	    
	    //compare	     
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList,oldList);
	}
}
