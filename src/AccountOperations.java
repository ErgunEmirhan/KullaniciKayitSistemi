import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AccountOperations {
	
	public static void userRegister(Scanner scanner){ // gerekli bilgiler alınır, sıkıntı yoksa kullanıcı oluşturulur
		
		// Bilgi al
		String damnHyphens = "--------------------------------------------";
		System.out.println(damnHyphens + "\n-----Registration System------\n" + damnHyphens);
		String idNo = getIdNo(scanner);
		LocalDate birthday = getBirthday(scanner);
		// yasal olarak yetişkin sayılıyor mu?
		if (!isMajor(birthday)) System.out.println("Sorry but minors are not allowed to register to our system!");
		String name = getName(scanner);
		String surname = getSurname(scanner);
		String eMail = getEMail(scanner);
		String phoneNumber = getPhoneNumber(scanner);
		String userName = getUserName(scanner);
		String password = getPassword(scanner);
		
		// Kullanıcıyı kaydet
		UserDataBase.save(new User(birthday, password, userName, phoneNumber, eMail, surname, name, idNo));
		System.out.println("Dear " + name + " " + surname + ", you have successfully registered to our server!");
	}
	
	public static void logIn(Scanner scanner){  // hesaba giriş
		String damnHyphens = "--------------------------------------------";
		System.out.println(damnHyphens + "\n-----Log-In Screen------------\n" + damnHyphens);
		scanner.nextLine();
		logIn:
		while (true) {
			int TRY_LIMIT_PASSWORD = 3;
			System.out.print("Enter your username> ");
			String tempUserName = scanner.nextLine();
			int userIndex = (UserDataBase.findUserName(tempUserName));
			if  (userIndex == -1){ // olmayan kullanıcı adı girildiyse döngünün başına dönülür
				System.out.println("This username does not exist.");
				continue;
			}
			for (int i = 0; i < TRY_LIMIT_PASSWORD; i++) { // şifreyi birkaç kez (try_limt_password) yanlış girdikten sonra erişim engellenir (döngü kırılır), doğru girilirse oturum başlatılır.
				System.out.print("Enter your password> ");
				String tempPassword = scanner.nextLine();
				if (UserDataBase.passwordMatches(tempPassword, userIndex)) {
					System.out.println("You have successfully logged in!");
					session(scanner);
					System.out.println("You have successfully logged out!");
					break logIn;
				}
				System.out.println("Incorrect password x_x");
			}
			System.out.println("Too many failed attempt.");
			break;
		}
	}
	
	private static void session(Scanner scanner) { // oturum
		session:
		while (true){
			System.out.println("Actions:\n0. Log-out");
			switch (scanner.nextInt()){
				case 0:
					break session;
				default:
					System.out.println("Action irrecognizable.");
			}
		}
	}
	
	private static String getIdNo(Scanner scanner){
		
		while (true){
			try{
				System.out.print("Please enter your identity number> ");
				long tempIdNo = scanner.nextLong();
				if ((int)Math.log10(tempIdNo) == 10) { // girilen kimlik no 11 haneli değilse
					scanner.nextLine();
					String tempId = String.valueOf(tempIdNo);
					if (UserDataBase.findIdNo(tempId) != -1){ // girilen kimlik no başka kullanıcıya aitse
						System.out.println("The identity number you have entered is already registered to the system.  If you are having trouble logging into your own account, you can use the \" I forgot my password\" option.  Do not imitate somebody else otherwise.");
						continue;
					}
					return tempId;
				}
				System.out.println("Your identity number must be of 11 digits.");
			}catch(Exception e){ // girilen kimlik no sayısal değilse
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
			catch (Exception e){ // uygun formatta girilmediyse
				System.out.println("Please regard to the instructions.");
			}
		}
	}
	
	private static boolean isMajor(LocalDate birthday) { // reşitlik hesabı
		return (18 <= Period.between(birthday, LocalDate.now()).getYears());
	}
	
	private static String getName(Scanner scanner){
		main:
		while (true){
			System.out.print("Enter your name pleaase> ");
			String tempName = scanner.nextLine();
			for (int i = 0; i < tempName.length(); i++) {
				if (!Character.isLetter(tempName.charAt(i))){ // isim herhangi bir yerde harf dışında bir şey içeriyorsa
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
				if (!Character.isLetter(tempName.charAt(i))){ // soyisim herhangi bir yerde harf dışında bir şey içeriyorsa
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
			if (UserDataBase.findEMail(tempEMail) != -1){  // e-mail sistemde önceden kayıtlıysa
				System.out.println("There already exists an account with this e-mail.  If you are the owner of that account and forgot your password, you can use \" I forgot my password\" option while logging in.");
				continue;
			}
			int len = tempEMail.length();
			// e-mail formatı düzgün mü
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
				if (tempPhoneNumber.length() == 10) return tempPhoneNumber; // numara 10 haneli mi
				System.out.println("Your phone number must be of 10 digits.");
			}
			catch(Exception e){ // numarada sayı dışında bir şey varsa
				System.out.println("Your phone number must consist of numbers only");
			}
		}
	}
	
	private static String getUserName(Scanner scanner){
		while (true) {
			System.out.println("What username would you like to use(Your username must be of length 8-16)?");
			String tempUserName = scanner.nextLine();
			if (!checkUserNameLength(tempUserName)) System.out.println("The username you entered is too long or too " +
					                                                           "short try another."); // karakter sayısı sınırlarına uyuldu mu
			else if (UserDataBase.findUserName(tempUserName) != -1){ // kullanıcı adı sistemde zaten kayıtlıysa
				System.out.println("This username is already taken.  Try another.");
			}
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
	
	public static void forgotMyPassword(Scanner scanner){
		String damnHyphens = "--------------------------------------------";
		System.out.println(damnHyphens + "\n------Forgot Your Password? Do not Worry!------\n" + damnHyphens);
		scanner.nextLine();
		int userIndex = identityCheck(scanner); // kullanıcının kimliğini tespit et (sahtekar değil mi diye bak)
		if (userIndex != -1) changePassword(scanner, userIndex); // şifre değişme metodu
		scanner.nextLine();
	}
	
	private static int identityCheck(Scanner scanner) {
		while (true) {
			System.out.print("What is your username?> ");
			String userName = scanner.nextLine();
			int tempUserIndex = UserDataBase.findUserName(userName);
			if (tempUserIndex == -1) { // girilen kullanıcı adı sistemde kayıtlı değilse
				System.out.println("There is no user registered as \"" + userName + "\" to our servers, please check if there is any typo.");
				continue;
			}
			System.out.print("Dear " + userName + ", enter your identity number> ");
			String idNo = scanner.nextLine();
			if (!UserDataBase.getUsers()[tempUserIndex].getIdNo().equals(idNo)){ // kullanıcının kimlik numarası yanlış girildiyse
				System.out.println("This identity number does not correspond with the one registered.  Access denied.");
				return -1;
			}
			System.out.println("Enter your registered e-mail adress.");
			String eMail = scanner.nextLine();
			if (!UserDataBase.getUsers()[tempUserIndex].getEMail().equals(eMail)){ // kullanıcının e-postası yanlış girildiyse
				System.out.println("This e-mail adress does not correspond with the one registered.  Access denied.");
				return -1;
			}
			System.out.println("You have successfully confirmed your identity.");
			return tempUserIndex;
			
		}
	}
	
	private static void changePassword(Scanner scanner, int userIndex){
		while (true){
			System.out.print("Enter your new password> ");
			String newPassword1 = scanner.nextLine();
			System.out.print("Enter your new password again> ");
			String newPassword2 = scanner.nextLine();
			if (newPassword2.equals(newPassword1)) {
				UserDataBase.getUsers()[userIndex].setPassword(newPassword1);
				System.out.println("Your password is changed successfully!");
				break;
			}
			System.out.println("The password you entered again was not the same, try again.");
		}
	}
	
}