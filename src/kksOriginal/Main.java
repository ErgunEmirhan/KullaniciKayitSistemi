package kksOriginal;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			UserDataBase.save(new User(LocalDate.of(2000,10,10), "asd", "yokEdici" + i, "5554442211",
			                           "ergun" + i + "@mail.com", "ergun" + i, "emir" + i, "1231231231" + i));
		}
		
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
	}
	
	public static void menu(Scanner scanner){
		String damnHyphens = "--------------------------------------------";
		mainMenu:
		while (true){
			System.out.println(damnHyphens + "\nWelcome to talkalot.com, what do you want to do?\n1. Register\n2. " +
					                   "Log-in\n3. Forgot my password\n4. Show all\n0. Exit\n " + damnHyphens);
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
					break;
				case 4:
					UserDataBase.showAllUsernames();
					scanner.nextLine();
					break;
				default:
					System.out.println("Input cannot be recognized.");
			}
		}
		
		System.out.println("Shutdown successful.");
	}
	
}