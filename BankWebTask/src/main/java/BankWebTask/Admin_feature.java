package BankWebTask;
import java.util.HashMap;
import java.util.Scanner;

public interface Admin_feature {
	boolean add_user();
	void update();
	void delete();
	Person user_search();
	Person business_search();
	Person search_menu();
	void display_all();
	void display_one(Person index);
	String validate(String input, Scanner scanner);
	String number_validate(String input, Scanner scanner);
	String email_validate(String input, Scanner scanner);
	String name_validate(String input, Scanner scanner);
	HashMap<String, String> add_user_login(Scanner scanner);
	HashMap<String, String> add_business_login(Scanner scanner);
}
