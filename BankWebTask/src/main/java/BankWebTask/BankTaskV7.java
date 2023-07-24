package BankWebTask;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BankTaskV7 extends Admin
{
	public ArrayList<Person> persons = new ArrayList<Person>();
	public BankTaskV7() 
	{
		// initialize person 1
		HashMap<String, String> person_logins1 = new HashMap<String, String>();
		HashMap<String, String> business_logins1 = new HashMap<String, String>();
		long balance1 = 1705;
		String name1 = "Nam Tran";
		String address1 = "123 Hi Street, San Diego, CA, 92111";
		String phone_num1 = "504-754-1450";
		
		person_logins1.put("user001", "123456");
		business_logins1.put("userB001", "123");
		
		Person person1 = new Person(person_logins1, business_logins1, balance1, name1, address1, phone_num1);
		persons.add(person1);
		
		// initialize person 2
		HashMap<String, String> person_logins2 = new HashMap<String, String>();
		HashMap<String, String> business_logins2 = new HashMap<String, String>();
		long balance2 = 5000;
		String name2 = "Random Bot";
		String address2 = "555 Random Street, San Antonio, CA, 92111";
		String phone_num2 = "222-222-2222";
		person_logins2.put("user002", "123456");
		business_logins2.put("userB002", "123");
		balance =  8000;
		name = "Tommy";
		address = "811 New Street, San Marcos, CA, 92011";
		phone_num = "222-222-2222";
		Person person2 = new Person(person_logins2, business_logins2, balance2, name2, address2, phone_num2);
		persons.add(person2);
		
		// initialize person 3
		HashMap<String, String> person_logins3 = new HashMap<String, String>();
		HashMap<String, String> business_logins3 = new HashMap<String, String>();
		person_logins3.put("user003", "123456");
		business_logins3.put("userB003", "123");	
		int balance3 =  2500;
		String name3 = "Random Bot";
		String address3 = "254 Old Street, San Marcos, CA, 92011";
		String phone_num3 = "111-111-1111";
		Person person3 = new Person(person_logins3, business_logins3, balance3, name3, address3, phone_num3);
		persons.add(person3);
	}
	
	public void log_in(BankTaskV7_user person, BankTaskV7_admin admin, BankTaskV7_Business business ,ChatBot bot)
	{
		int cont = -1;
		Scanner scanner = new Scanner(System.in);
		bot.chatBot();
		do
		{
			boolean valid = false;
			System.out.println("What logIn do you choose?");
			System.out.println("1. User");
			System.out.println("2. Admin");
			int choice = 0;
			while (!valid){
	            try
	            {
	                System.out.println("Enter your choice: ");
	                choice = scanner.nextInt();
	                valid = true;
	            } catch (InputMismatchException e)
	            {
	                System.out.println("Invalid input. Please enter a valid number.");
	                scanner.next();
	            }
	        }
			valid = false;
			scanner.nextLine();
			switch(choice)
			{
				case 1:
					System.out.println("What account do you choose?");
					System.out.println("1. Personal Account");
					System.out.println("2. Business Account");
					System.out.println("Enter your choice: ");
					int choice1 = scanner.nextInt();
					scanner.nextLine();
					switch(choice1)
					{
						case 1:
							person.user_menu();
							break;
						case 2:
							business.user_menu();
					}
					break;
				case 2:
					admin.user_check();
					break;
				default:
					System.out.println("Unvailable");
			}
			System.out.println("Want to continue? ");
			System.out.println("1. Yes ");
			System.out.println("2. No ");
			while (!valid){
				try
		        {
					System.out.println("Enter your choice: ");
		            cont = scanner.nextInt();
		            valid = true;
		        }catch (InputMismatchException e)
		        {
		        	System.out.println("Invalid input. Please enter a valid number.");
		            scanner.next();
		        }
		    }
			scanner.nextLine();
		}while(cont != 2);
		System.out.println("Thank You for using Online Banking");
	}
}
