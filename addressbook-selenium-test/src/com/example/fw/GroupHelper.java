package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void initGroupCreation() {
		click(By.name("new"));
	  }

	public void submitGroupCreation() {
		click(By.name("submit"));
	  }

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	  }

	public void returnToGroupsPage() {
		click(By.linkText("group page"));		
	  }
}
