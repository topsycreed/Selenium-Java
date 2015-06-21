package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
	
	private NavagationHelper navagationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public ApplicationManager() {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //groupHelper = new GroupHelper(this);
	    //contactHelper = new ContactHelper(this);
	    //navagationHelper = new NavagationHelper(this);
	}
	
	public void stop() {
	    driver.quit();
	    }
	
	public NavagationHelper getNavagationHelper(){
		if (navagationHelper == null) {
			navagationHelper = new NavagationHelper(this);
		}
		return navagationHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
}

