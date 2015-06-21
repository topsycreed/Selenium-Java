package com.example.fw;

import org.openqa.selenium.By;

public class NavagationHelper extends HelperBase {
	
	public NavagationHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	  }

	public void gotoGroupsPage() {
		click(By.linkText("groups"));
	  }
}
