import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
	}
	
	public static void menu(Scanner scanner){
		String damnHyphens = "--------------------------------------------";
		mainMenu:
		while (true){
			System.out.println(damnHyphens + "\nWelcome to talkalot.com, what do you want to do?\n1. Register\n2. " +
					                   "Log-in\n3. Forgot my password\n0. Exit\n " + damnHyphens);
			switch(scanner.nextInt()){
				case 0:
					break mainMenu;
				case 1:
					AccountOperations.userRegister(scanner);
					break;
				case 2:
					AccountOperations.logIn(scanner);
					break;
				case 3:
					AccountOperations.forgotMyPassword(scanner);
				default:
					System.out.println("Input cannot be recognized.");
			}
		}
		
		System.out.println("Shutdown successful.");
	}
}