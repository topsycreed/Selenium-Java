package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	
	 @Test(dataProvider="randomValidGroupGenerator")
	 public void modifySomeGroup(GroupData group)
	 {
		 app.navigateTo().mainPage();
	     app.navigateTo().groupsPage();
	     
	     // save old
	     SortedListOf<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	     Random rnd =new Random();
	     int index=rnd.nextInt(oldList.size()-1);
	     
	     //actions
	     app.getGroupHelper().modifyGroup(index,group);

	     // save new
	     SortedListOf<GroupData> newList=app.getGroupHelper().getGrous(); 
	    
	     assertThat(newList,equalTo(oldList.without(index).withAdded(group)));
	 }
}