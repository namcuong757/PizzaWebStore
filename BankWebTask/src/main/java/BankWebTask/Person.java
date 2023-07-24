package BankWebTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
	public HashMap<String, String> person_logins = new HashMap<String, String>();
	public HashMap<String, String> business_logins = new HashMap<String, String>();
	
	public String admin;
	public String admin_passWord;
	public long balance;
	public String name;
	public String address;
	public String phone_num;
	
	public Person(){}
	public Person(HashMap<String, String> person_logins, HashMap<String, String> business_logins, long balance, String name, String address, String phone_num)
	{
		this.person_logins = person_logins;
		this.business_logins = business_logins;
		this.balance = balance;
		this.name = name;
		this.address = address;
		this.phone_num = phone_num;
	}
}
