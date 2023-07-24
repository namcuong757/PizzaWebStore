
public class BankTaskV6Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankTaskV6 main = new BankTaskV6();
		BankTaskV6_user user = new BankTaskV6_user();
		BankTaskV6_admin admin = new BankTaskV6_admin();
		ChatBot bot = new ChatBot();
		
		main.log_in(user, admin, bot);
	}
}
