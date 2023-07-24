package BankWebTask;

public class BankTaskV7Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankTaskV7 main = new BankTaskV7();
		BankTaskV7_user user = new BankTaskV7_user();
		BankTaskV7_admin admin = new BankTaskV7_admin();
		BankTaskV7_Business business = new BankTaskV7_Business();
		ChatBot bot = new ChatBot();
		
		main.log_in(user, admin, business,bot);
	}
}
