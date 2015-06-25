package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;


public class TestBase {

	protected ApplicationManager app;

	@BeforeClass
		public void setUp() throws Exception {
	    Properties properties = new Properties();
	    properties.load(new FileReader (new File( "application.properties")) );
		app=new ApplicationManager(properties);
		
	  }

	@AfterClass
	public void tearDown() throws Exception {
		app.stop();
	    
	  }

	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {

		List<Object[]>list= new ArrayList<Object[]>();
		for(GroupData group: groups){
			list.add(new Object[]{group});
		}
		
		return list;
	}

	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {

	    List<Object[]>list= new ArrayList<Object[]>();
		for(ContactData contact: contacts){
			list.add(new Object[]{contact});
		}
		
		return list;
	}

public String generateRandomDay(){
		
		Random rnd =new Random();
		if(rnd.nextInt(3)==0){
			return"-";
			
		}
		else return "1"+ rnd.nextInt(3);
		
	}
	
 public String generateRandomMonths(){
	 
	 Random rnd =new Random();
	 String months[] = { "January", "February", "June", "July",
	           "December"};
	   int mon=rnd.nextInt(months.length);
	   return months[mon];
 }
	
public String generateRandomYear(){
	 
	 Random rnd =new Random();
	 
	 return "198"+ rnd.nextInt(3);
}

public static String generateRandomString(){
	
	Random rnd =new Random();
	if(rnd.nextInt(3)==0){
		return"";
	}
	
	else return "test"+ rnd.nextInt();
	
 }

}