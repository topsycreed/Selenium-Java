package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {
	

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initGroupCreation() {
	    click(By.name("new"));
	}

	public void submitGroupCreation() {
		 click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
	   type(By.name("group_name"), group.groupName);
	   type(By.name("group_header"), group.header);
	   type(By.name("group_footer"), group.footer);
	  }

	public void returnToGroupPage() {
		click(By.linkText("group page"));
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		// System.out.println(count);
	}

	public void deleteGroup(int index) {
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index <= count){
		selectGroupByIndex(index);
		click(By.name("delete"));
		}
	}

	private void selectGroupByIndex(int index) {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index <= count){
		click(By.xpath("//input[@name='selected[]'][" + index+"]"));
		}
	}
	
	private void selectAllGroups() {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0){
		for (int i=1;i<=count;i++){
		click(By.xpath("//input[@name='selected[]'][" + i+"]"));
			}
		}
	}
	
	
	private void selectSomeGroups(int index) {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		if (count != 0 && index < count){
		for (int b=1;b<=index;b++){
		click(By.xpath("//input[@name='selected[]'][" + b+"]"));
			}
		}
		else {
			
			for (int b=1;b<count;b++){
				click(By.xpath("//input[@name='selected[]'][" + b+"]"));
					}
		}
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));

	}

	public void submitGroupModification() {
		
		click(By.name("update"));
		
	}

	public void deleteGroups() {
		selectAllGroups();
		click(By.name("delete"));
	}
	
	public void deleteSomeGroups(int index) {
		selectSomeGroups(index);
		click(By.name("delete"));
		}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
		GroupData group = new GroupData(); 	
		String title = checkbox.getAttribute("title");
		group.groupName = title.substring("Select (".length(), title.length()-")".length());
		groups.add(group);
		}
		return groups;
	}
	
	public String CharacterRandomizer(int index) {
		   String charset = ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuvwxyz");
		   String name = RandomStringUtils.random(index,charset);
		   return name;	  
	 }

	public int returnCount() {
		
		int count = clicks(By.xpath("//input[@name='selected[]']"));
		return count;
	}
}