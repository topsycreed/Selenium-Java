package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCrearionTests extends TestBase {
	
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
}