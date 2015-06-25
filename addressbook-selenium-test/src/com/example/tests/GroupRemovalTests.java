package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	 @Test
public void deleteSomeGroup()	 
	 {   
		 SortedListOf<GroupData> oldList=app.getGroupHelper().getGrous();
		 
	     Random rnd =new Random();
	     int index=rnd.nextInt(oldList.size()-1);
	     
	    //actions
	     app.getGroupHelper().deleteGroup(index);
	     
	     // save new
	     SortedListOf<GroupData> newList=app.getGroupHelper().getGrous(); 
	    
	     //compare
	     
	     assertThat(newList,equalTo(oldList.without(index)));
	 }
}