package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String home2;

	public ContactData() {
		
	}
	
	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String address2, String home2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.home2 = home2;
	}
}