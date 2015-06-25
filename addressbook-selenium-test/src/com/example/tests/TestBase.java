package com.example.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected ApplicationManager app;

	@BeforeClass
		public void setUp() throws Exception {
	    app=new ApplicationManager();
		
	  }

	@AfterClass
	public void tearDown() throws Exception {
		app.stop();
	    
	  }

	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]>list= new ArrayList<Object[]>();
	 		
		for( int i =0;i<3;i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())	
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
			
		return list.iterator();
	}
	

	public String generateRandomString(){
		
		Random rnd =new Random();
		if(rnd.nextInt(3)==0){
			return"";
		}
		
		else return "test"+ rnd.nextInt();
		
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

	public Calendar generateRandomDate(){

		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(2000, 2015);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return gc;
	}

	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]>list= new ArrayList<Object[]>();
	 		
		for( int i =0;i<2;i++){
			ContactData contacts = new ContactData()
			.withFirstName(generateRandomString())	
			.withLastName(generateRandomString())
			.withAddr(generateRandomString())
			.withEmail(generateRandomString())
			.withPhone(generateRandomString())
			.withBirthDay(generateRandomDate().get(Calendar.DAY_OF_MONTH))
			.withBirthMonth(generateRandomDate().getDisplayName(Calendar.MONTH, Calendar.LONG,new Locale("eng", "US")))
			.withBirthYear(generateRandomDate().get(Calendar.YEAR));
						
			list.add(new Object[]{contacts});
		}
			
		return list.iterator();
	}
}