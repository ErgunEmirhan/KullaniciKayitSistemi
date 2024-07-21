import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AccountOperations {
	
	public static void userRegister(Scanner scanner){
		String idNo = getIdNo(scanner);
		LocalDate birthday = getBirthday(scanner);
		if (!isMajor(birthday)) System.out.println("Sorry but minors are not allowed to register to our system!");
		String name = getName(scanner);
		String surname = getSurname(scanner);
		String eMail = getEMail(scanner);
		String phoneNumber = getPhoneNumber(scanner);
		String userName = getUserName(scanner);
		String password = getPassword(scanner);
		
		
	}
	
	
	
	private static String getIdNo(Scanner scanner){
		
		while (true){
			try{
				System.out.print("Please enter your identity number> ");
				long tempIdNo = scanner.nextLong();
				if ((int)Math.log10(tempIdNo) == 10) {
					scanner.nextLine();
					return String.valueOf(tempIdNo);
				}
				System.out.println("Your identity number must be of 11 digits.");
			}catch(Exception e){
				System.out.println("Your identity number must consist of numbers only.");
				scanner.nextLine();
			}
		}
	}
	
	private static LocalDate getBirthday(Scanner scanner){
		
		while (true){
			try{
				System.out.print("Enter your birthday, the year at the beginning and the day at the end(ex. " +
						                 "1970-02-25)> ");
				return LocalDate.parse(scanner.nextLine());
			}
			catch (Exception e){
				System.out.println("Please regard to the instructions.");
			}
		}
	}
	
	private static boolean isMajor(LocalDate birthday) {
		return (18 <= Period.between(birthday, LocalDate.now()).getYears());
	}
	
	private static String getName(Scanner scanner){
		main:
		while (true){
			System.out.print("Enter your name pleaase> ");
			String tempName = scanner.nextLine();
			for (int i = 0; i < tempName.length(); i++) {
				if (!Character.isLetter(tempName.charAt(i))){
					System.out.println("Your name must consist of letters only.");
					continue main;
				}
			}
			return tempName;
		}
	}
	
	private static String getSurname(Scanner scanner){
		main:
		while (true){
			System.out.print("Enter your surname pleaase> ");
			String tempName = scanner.nextLine();
			for (int i = 0; i < tempName.length(); i++) {
				if (!Character.isLetter(tempName.charAt(i))){
					System.out.println("Your name must consist of letters only.");
					continue main;
				}
			}
			return tempName;
		}
	}
	
	private static String getEMail(Scanner scanner) {
		while (true){
			System.out.print("Enter your e-mail please> ");
			String tempEMail = scanner.nextLine();
			int len = tempEMail.length();
			if (tempEMail.indexOf('@') == -1) System.out.println("Your e-mail adress is missing @");
			else if (tempEMail.indexOf('@') != tempEMail.lastIndexOf('@')) System.out.println("Your e-mail contains " +
					                                                                                  "more than one " +
					                                                                                  "@");
			
			else if (tempEMail.substring(len-4,len-2).indexOf('.') == -1) System.out.println("Your e-mail adress is " +
					                                                                                 "missing TLD");
			else return tempEMail;
		}
	}
	
	private static String getPhoneNumber(Scanner scanner){
		while (true){
			System.out.print("Enter your phone number please> +90 ");
			String tempPhoneNumber = scanner.nextLine().replace(" ", "");
			try{
				Long.parseLong(tempPhoneNumber);
				if (tempPhoneNumber.length() == 10) return tempPhoneNumber;
				System.out.println("Your phone number must be of 10 digits.");
			}
			catch(Exception e){
				System.out.println("Your phone number must consist of numbers only");
			}
		}
	}
	
	private static String getUserName(Scanner scanner){
		while (true) {
			System.out.println("What username would you like to use(Your username must be of length 8-16?");
			String tempUserName = scanner.nextLine();
			if (!checkUserNameLength(tempUserName)) System.out.println("The username you entered is too long or too " +
					                                                           "short try another.");
			else return tempUserName;
		}
	}
	
	private static boolean checkUserNameLength(String username){
		int MIN_LENGTH = 8;
		int MAX_LENGTH = 16;
		int usernameLength = username.length();
		return !(usernameLength < MIN_LENGTH || usernameLength > MAX_LENGTH);
		
	}
	
	private static String getPassword(Scanner scanner){
		while (true){
			System.out.print("Enter your password> ");
			String tempPass1 = scanner.nextLine();
			System.out.print("Enter your password again> ");
			String tempPass2 = scanner.nextLine();
			if (tempPass2.equals(tempPass1)) return tempPass2;
			else System.out.println("You entered two different passwords x_x");
		}
	}
	
}