package BankWebTask;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BankTaskV7_admin extends BankTaskV7 implements Features, Admin_feature{
	//Scanner scanner = new Scanner(System.in);
	public BankTaskV7_admin()
	{
		super();
	}
	
	@Override
	public void user_check() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int flag = 0, conti = -1;
		//Scanner scanner = new Scanner(System.in);
		do {
			boolean valid = false;
			System.out.println("\n################# ADMIN AREA #################\n" );
			System.out.println("ADMIN AUTHENTICATION" );
			System.out.println("Enter your adminID:" );
			String user = scanner.nextLine();
			System.out.println("Enter user Admin Password:" );
			String pass = scanner.nextLine();
			
			System.out.println("----LOGGING IN...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < 1; i++) {
				if(admin_user.equals(user) && admin_pass.equals(pass)) {
					
					System.out.println("\n---Successfully Logging In---\n" );
					int cont = 0;
					do
					{
						valid = false;
						while (!valid) {
							try {
								System.out.println("What do you want to do?");
								System.out.println("1. Print all users\n2. Add new user\n3.Search User\n4.Update User\n5.Delete User");
								System.out.println("Enter your choice");
								int choice = scanner.nextInt();
								switch (choice) {
								case 1:
									display_all();
									break;
								case 2:
									add_user();
									break;
								case 3:
									search_menu();
									break;
								case 4:
									update();
									break;
								case 5:
									delete();
									break;
								default:
									System.out.println("Invalid answer");
									break;
								}
								valid = true;
							} catch (InputMismatchException e) {
								System.out.println("Please enter numeric charater");
								scanner.nextLine();
							}
							// Consume the newline character
						}
						valid = false;
						while (!valid) {
							try {
								System.out.print("Enter any number to return to menu\n0 to exit: ");
								cont = scanner.nextInt();
								valid = true;
							} catch (InputMismatchException e) {
								System.out.println("Invalid input. Please enter a valid number.");
								scanner.next();
							} 
						}
						//scanner.next();
					}while(cont != 0);
					
					flag = 1;
					break;
				}
			}
			valid = false;
			if(flag == 0) {
				System.out.println("====Failed to log in====\n");
				break;
			}
			
			System.out.println("Would you like to retry log in?\n1. Yes\n2. No");
			while (!valid ) {
				try {
					System.out.println("Enter your choice: ");
					conti = scanner.nextInt();
					if(conti >= 1 && conti <= 2)
					{
						valid = true;
					}
					else
					{
						System.out.println("Enter valid choice\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid number.");
					scanner.next();
				} 
			}
			scanner.nextLine(); // Consume the newline character
		} while(conti != 2);
		say_bye();
		//scanner.close();
	}

	@Override
	public void say_bye() {
		// TODO Auto-generated method stub
		System.out.println("LOG OUT OF ADMIN");
	}
	public void display_all()
	{
		
		for(Person person : persons)
		{
			
//			for(Map.Entry<String, String> entry : person.person_logins.entrySet())
//			{
//				System.out.println("Username: " + entry.getKey());
//				System.out.println("Password: " + entry.getValue());
//			}
			System.out.println(person.person_logins);			
			System.out.println("Balances: " + person.balance);		
			System.out.println("Name: " + person.name);		
			System.out.println("Address: " + person.address);;		
			System.out.println("Phone Number: " + person.phone_num);
			System.out.println("---------------------" );
		}
		
	}
	@Override
	public boolean add_user() throws InputMismatchException{
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		boolean valid = false;
		while (!valid) {
			try {
				System.out.println("Would you like to add a new user?\n1. Yes\n2. No");
				choice = scanner.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				scanner.next();
			} 
		}
		valid = false;
		scanner.nextLine();
		if(choice == 1)
		{
			System.out.println("== ADDING NEW USER ==" );
			
			System.out.println("Enter user userID:" );
			String user = scanner.nextLine();
			user = validate(user, scanner);
			System.out.println("Enter user password:" );
			String pass = scanner.nextLine();
			pass = validate(pass, scanner);
			System.out.println("Enter user Business userID:" );
			String userB = scanner.nextLine();
			userB = validate(userB, scanner);
			System.out.println("Enter user Business password:" );
			String passB = scanner.nextLine();
			passB = validate(passB, scanner);
			System.out.println("Enter user balance:" );
			int balance = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter user Name:" );
			String name = scanner.nextLine();
			name = name_validate(name, scanner);
			System.out.println("Enter user Address:" );
			String address = scanner.nextLine();
			address = validate(address, scanner);
			System.out.println("Enter user PhoneNumbers:" );
			String phone_num = scanner.nextLine();
			phone_num = number_validate(phone_num, scanner);
			HashMap<String, String> person_logins = new HashMap<String, String>();
			HashMap<String, String> business_logins = new HashMap<String, String>();
			person_logins.put(user, pass);
			business_logins.put(userB, passB);
			Person new_person = new Person(person_logins, business_logins, balance, name, address, phone_num);
			
			persons.add(new_person);
			System.out.println("-Succefully Added-" );
			return true;
		}
		return false;
	}
	
	@Override
    public Person user_search() {
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        try {
            System.out.println("== SEARCHING USER ==");
            System.out.println("Enter userID:");
            String user = scanner.nextLine();

            for (Person person_i : persons) {
                for (Map.Entry<String, String> entry : person_i.person_logins.entrySet()) {
                    if (entry.getKey().equals(user)) {
                        person = person_i;
                        break; // Found a match, no need to continue searching
                    }
                }
                if (person != null) {
                    System.out.println("---Found User---");
                    break; // Found a match, no need to continue searching
                }
            }

            if (person == null) {
                System.out.println("- Cannot Find User -");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return person;
    }
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("== MODIFYING NEW USER ==" );
		System.out.println("Which account do you want to adjust?\n1.Personal Account\n2.Business Account");
		String choice = scanner.nextLine();
		Person person = null;
		HashMap<String, String> person_logins = new HashMap<String, String>();
		HashMap<String, String> business_logins = new HashMap<String, String>();
		switch(choice)
		{
			case "1":
				person = user_search();
				if(person == null) break;
				person_logins = add_user_login(scanner);
				break;
			case "2":
				person = business_search();
				if(person == null) break;
				business_logins = add_business_login(scanner);
				break;
			default:
				System.out.println("Not available");
		}
		
		if(person != null)
		{
			
			System.out.println("Enter new user balance:" );
			person.balance = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter new user Name:" );
			String name_temp = scanner.nextLine();
			name_temp = name_validate(name_temp,scanner);
			person.name = name_temp;
			System.out.println("Enter new user Address:" );
			String address_temp = scanner.nextLine();
			address_temp = validate(address_temp,scanner);
			person.address = address_temp;
			System.out.println("Enter new user PhoneNumbers:" );
			String phone_temp = scanner.nextLine();
			phone_temp = number_validate(phone_temp, scanner);
			person.phone_num = phone_temp;
			person.person_logins = person_logins;
			person.business_logins = business_logins;
			
			System.out.println("-Succefully Modify-" );
			display_one(person);
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		Person person = search_menu();
		if(person != null)
		{
			persons.remove(person);
			System.out.println("-Succefully Delete-" );
		}
	}
	@Override
	public void display_one(Person person) 
	{
		// TODO Auto-generated method stub
		System.out.println(person.person_logins);
		System.out.println(person.business_logins);
		System.out.println("Balances: " + person.balance);		
		System.out.println("Name: " + person.name);		
		System.out.println("Address: " + person.address);;		
		System.out.println("Phone Number: " + person.phone_num);
		System.out.println("---------------------" );
	}
	@Override
	public String validate(String input, Scanner scanner) {
        Pattern pat = Pattern.compile("[a-zA-Z0-9]{6,}");
        Matcher matcher = pat.matcher(input);
        boolean valid = matcher.matches();
        
        while (!valid) {
            System.out.println("Invalid input. Try again");
            input = scanner.nextLine();
            matcher = pat.matcher(input);
            valid = matcher.matches();
        }
        
        return input;
    }
	@Override
	public String email_validate(String input, Scanner scanner) {
		Pattern pat = Pattern.compile("@");
        Matcher matcher = pat.matcher(input);
        boolean valid = matcher.find();
        
        while (!valid) {
            System.out.println("Invalid input. Try again");
            input = scanner.nextLine();
            matcher = pat.matcher(input);
            valid = matcher.find();
        }
        
        return input;
	}
	@Override
	public String number_validate(String input, Scanner scanner) {
		Pattern pat = Pattern.compile("\\d{10}");
        Matcher matcher = pat.matcher(input);
        boolean valid = matcher.matches();
        
        while (!valid) {
            System.out.println("Invalid input. Try again");
            input = scanner.nextLine();
            matcher = pat.matcher(input);
            valid = matcher.matches();
        }
        
        return input;
	}
	@Override
	public String name_validate(String input, Scanner scanner) {
		Pattern pat = Pattern.compile("[a-zA-Z0-9]{6,}");
        Matcher matcher = pat.matcher(input);
        boolean valid = matcher.matches();
        
        while (!valid) {
            System.out.println("Invalid input. Try again");
            input = scanner.nextLine();
            matcher = pat.matcher(input);
            valid = matcher.matches();
        }
        
        return input;
	}
	@Override
	public HashMap<String, String> add_user_login(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("Enter new userID:" );
		String user = scanner.nextLine();
		user = validate(user,scanner);
		System.out.println("Enter new password:" );
		String pass = scanner.nextLine();
		pass = validate(pass, scanner);
		HashMap<String, String> person_logins = new HashMap<String, String>();
		person_logins.put(user, pass);
		return person_logins;
	}
	@Override
	public HashMap<String, String> add_business_login(Scanner scanner) {
		// TODO Auto-generated method stub
		HashMap<String, String> business_logins = new HashMap<String, String>();
		System.out.println("Enter new Business userID:" );
		String userB = scanner.nextLine();
		userB = validate(userB, scanner);
		System.out.println("Enter new Business password:" );
		String passB = scanner.nextLine();
		passB = validate(passB, scanner);
		business_logins.put(userB, passB);
		return business_logins;
	}

	
	@Override
	public Person business_search() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Person person = null;
		try {
			System.out.println("== SEARCHING USER ==" );
			System.out.println("Enter userID:" );
			String user = scanner.nextLine();
			
			for(Person person_i : persons)
			{
				for(Map.Entry<String, String> e : person_i.business_logins.entrySet())
				{
					if(e.getKey().equals(user)) 
					{
						person = person_i;
						break;
					}
				}
				if (person != null) {
					
                    break; // Found a match, no need to continue searching
                }
			}
			if(person == null)
			{
				System.out.println("-Cannot Found User-" );
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
		return person;
	}

	@Override
	public Person search_menu() {
		Person person = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which account you want to search \n1.Personal Account\n2.Business Account");
		String choice = scanner.nextLine();
		switch(choice)
		{
			case "1":
				person = user_search();
				break;
			case "2":
				person = business_search();
				break;
			default:
				System.out.println("Not available");
		}
		return person;
	}
	


}
