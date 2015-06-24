package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {
	   driver.get(manager.baseUrl + "/addressbookv4.1.4");
		List<WebElement> lastNames = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr/td[2]"));
		System.out.println(lastNames);
	}

	public void goToGroupPage() {
		click(By.linkText("groups"));
	}
}