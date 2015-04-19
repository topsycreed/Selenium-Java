package com.example.tests;

import org.testng.annotations.Test;

public class GroupCrearionTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData("test 1", "header 1", "footer 1");
    group.name = "name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
}