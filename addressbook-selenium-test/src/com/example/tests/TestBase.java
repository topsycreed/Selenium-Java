package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i =0;i<3;i++){
			GroupData group = new GroupData();
			group.groupName = generateRandomString(10);
			group.footer = generateRandomString(100);
			group.header=generateRandomString(100);
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i =0;i<1;i++){
			ContactData contact = new ContactData();
			 contact.firstName = app.getContactHelper().NameRandomizer();
			    contact.secondName = app.getContactHelper().NameRandomizer();
			    contact.postAddress = "North Pole";
			    contact.homePhoneNum = app.getContactHelper().phoneRandomizer();
			    contact.mobilePhonNum = app.getContactHelper().phoneRandomizer();
			    contact.workPhoneNum = app.getContactHelper().phoneRandomizer();
			    contact.postPrimary = app.getContactHelper().emailRandomizer();
			    contact.postSecondary = app.getContactHelper().emailRandomizer();
			    contact.day ="18";
			    contact.month = "January";
			    contact.year = "1982";
			    contact.secondaryPostAddress = "South Pole";
			    contact.secondaryPhone = "+42300011122";
			    list.add(new Object[]{contact});
		}
		return list.iterator();
	}

	public String generateRandomString(int index)
	{
		Random rnd = new Random();
		if (rnd.nextInt(5)==0)
		{
			return "";
		}
		else{
		return app.getGroupHelper().CharacterRandomizer(index);
		}
	}
}