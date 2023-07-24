
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankTaskV6_user extends BankTaskV6 implements Features{
	
	public BankTaskV6_user() 
	{
		super();
	}	
	@Override
	public void user_check() {
		// TODO Auto-generated method stub
		int flag = 0, conti = -1;
		
		Scanner scanner = new Scanner(System.in);
		do {
			boolean valid = false;
			System.out.println("\n$$$$$$$$$$$$$ Online Banking Personal $$$$$$$$$$$$$\n" );
			System.out.println("Would you like to view your balance?" );
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
			
			for(int i = 0; i < ids.size(); i++) {
				if(ids.get(i).equals(user) && passWords.get(i).equals(pass)) {
					System.out.println("---Successfully Logging In---" );
					
					System.out.println("=====================================");
					System.out.println("#Client Informations#");
					System.out.println("Name: " + names.get(i));
					System.out.println("Address: " + addresses.get(i));
					System.out.println("Phone Number: " + phone_nums.get(i));
					System.out.println("=====================================");
					
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
									System.out.println("Your current balance: $" + balances.get(i));
									break;
								case 2:
									say_bye();
									break;
								default:
									System.out.println("Invalid answer");
							}
			                valid = true;
			            } catch (InputMismatchException e)
			            {
			                System.out.println("Invalid input. Please enter a valid number.");
			                scanner.next();
			            }
			        }
					
					flag = 1;
					break;
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

	@Override
	public void say_bye() {
		// TODO Auto-generated method stub
		System.out.println("LOG OUT OF USER");
	}

}
