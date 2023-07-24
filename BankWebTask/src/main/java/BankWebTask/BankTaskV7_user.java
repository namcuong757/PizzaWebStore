package BankWebTask;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankTaskV7_user extends BankTaskV7 implements Features{
	
	public BankTaskV7_user() 
	{
		super();
	}	
	
	public void user_menu()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n$$$$$$$$$$$$$ Online Banking Personal $$$$$$$$$$$$$\n" );	
		System.out.println("1. List log in information");
		System.out.println("2. Would you like to view your balance?" );
		System.out.println("Enter choice: " );
		String choice_start = scanner.nextLine();
		switch(choice_start)
		{
			case "1":
				print_logIn();
				break;
			case "2":
				user_check();
				break;
			default:
				System.out.println("Invalid input");
		}
	}
	@Override
	public void user_check() {
		// TODO Auto-generated method stub
		int flag = 0, conti = -1, i = 0;
		
		Scanner scanner = new Scanner(System.in);
		do {
			boolean valid = false;				
			
			System.out.println("Enter your userID:" );
			String user = scanner.nextLine();
			System.out.println("Enter your password:" );
			String pass = scanner.nextLine();
			
			System.out.println("----LOGGING IN...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(Person person : persons) {
				for(Map.Entry<String, String> e : person.person_logins.entrySet())
				{
					if(e.getKey().equals(user) && e.getValue().equals(pass)) 
					{
						System.out.println("---Successfully Logging In---" );
						display_one(person);
						System.out.println("Would you like to view your balance?");
						System.out.println("1. Yes\n2. No");
						while (!valid){
				            try
				            {
				            	System.out.println("Enter your choice");
								int choice = scanner.nextInt();
								
								switch(choice)
								{
									case 1: 
										System.out.println("Your current balance: $" + person.balance);
										break;
									case 2:
										say_bye();
										break;
									default:
										System.out.println("Invalid answer");
								}
				                valid = true;
				            } catch (InputMismatchException e1)
				            {
				                System.out.println("Invalid input. Please enter a valid number.");
				                scanner.next();
				            }
				        }
						
						flag = 1;
						break;
					}
				}
				
			}
			valid = false;
			if(flag == 0) {
				System.out.println("====Failed to log in====\n");
			}
			
			System.out.println("Would you like to view another Personal account?\n1. Yes\n2. No");
			while (!valid) {
				try {
					System.out.println("Enter your choice: ");
					conti = scanner.nextInt();
					valid = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid number.");
					scanner.next();
				} 
			}
			scanner.nextLine(); // Consume the newline character
		} while(conti != 2);
		say_bye();
	}
	public void display_one(Person person)
	{
		System.out.println("=====================================");
		System.out.println("#Client Informations#");
		System.out.println("Name: " + person.name);
		System.out.println("Address: " + person.address);
		System.out.println("Phone Number: " + person.phone_num);
		System.out.println("=====================================");
		
	}
	@Override
	public void say_bye() {
		// TODO Auto-generated method stub
		System.out.println("LOG OUT OF USER");
	}
	public void print_logIn()
	{
		for(Person person : persons)
		{
			System.out.println(person.person_logins);
			System.out.println("#########################");
		}
		
	}
}
