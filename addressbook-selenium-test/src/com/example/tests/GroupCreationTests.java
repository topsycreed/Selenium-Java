package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;


	public class GroupCreationTests extends TestBase {

	@Test(dataProvider="randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		 	       
	     // save old	    
	     SortedListOf<GroupData> oldList=app.getGroupHelper().getGrous();
	     
	     //action
	    app.getGroupHelper().createGroup(group);

	    // save new
	    SortedListOf<GroupData> newList=app.getGroupHelper().getGrous();

	    assertThat(newList,equalTo(oldList.withAdded(group)));
	  }
}