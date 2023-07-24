
import java.util.Scanner;

public class ChatBot implements ChatBotInterface{
	
	@Override
	public void chatBot() {
		// TODO Auto-generated method stub
		System.out.println("Online Banking Application");
		System.out.println("====================");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello...What is your name?");
		String name = scanner.nextLine();
		System.out.println("Hello " + name + "! How are you today?" );
	}	
}
