
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BankTaskV6
{
	private ConfigInterface config = new Config();
    private Connection con = config.config();
    private PreparedStatement prepare = null;
    private ResultSet rs = null;
	public ArrayList<String> ids = new ArrayList<String>();
	public ArrayList<String> passWords = new ArrayList<String>();
	public String admin;
	public String admin_passWord;
	public ArrayList<Long> balances = new ArrayList<Long>();
	public ArrayList<String> names = new ArrayList<String>();
	public ArrayList<String> addresses = new ArrayList<String>();
	public ArrayList<String> phone_nums = new ArrayList<String>();	
	
	public BankTaskV6() 
	{
		admin = "admin";
		admin_passWord = "222";
		String query = "Select * from Bank;";
		
		con = config.config();
		try
		{
			prepare = con.prepareStatement(query);
			ResultSet resultSet = prepare.executeQuery(query);
			while (resultSet.next()) {
			    int balance = resultSet.getInt("balance");
			    String name = resultSet.getString("name");
			    String address = resultSet.getString("address");
			    String phone = resultSet.getString("phone");
			    balances.add((long) balance);
			    names.add(name);
			    addresses.add(address);
			    phone_nums.add(phone);
			}    
		}
			catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		String logIn_query = "Select * from logIn;";
		try
		{
			prepare = con.prepareStatement(logIn_query);
			ResultSet resultSet = prepare.executeQuery(query);
			while (resultSet.next()) {
			    String id = resultSet.getString("ID");
			    String pass = resultSet.getString("password");
			    ids.add(id);
			    passWords.add(pass);
			}    
		}
			catch(SQLException e)
		{
			
			e.printStackTrace();
		}
//		ids.add("user001");
//		ids.add("user002");
//		
//		passWords.add("123456");
//		passWords.add("1234");
//		
//		balances.add((long) 1705);
//		balances.add((long)5820);
//		
//		names.add("Nam Tran");
//		names.add("Random Bot");
//		
//		addresses.add("123 Hi Street, San Diego, CA, 92111");
//		addresses.add("125 Nice Street, San Jose, CA, 92151");
//		
//	
//		phone_nums.add("504-754-1450");
//		phone_nums.add("858-222-1111");
	}
	public void log_in(BankTaskV6_user person, BankTaskV6_admin admin, ChatBot bot)
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
					person.user_check();
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
