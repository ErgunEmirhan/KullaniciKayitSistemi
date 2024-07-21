public class UserDataBase {
	
	private static UserListDynamic users = new UserListDynamic();
	
	public static User[] getUsers(){ // database'deki kullanıcılara erişim sağlanır
		return users.getUserList();
	}
	
	public static void save(User user){ // database'e kullanıcı ekleme
		users.add(user);
	}
	
	public static void showAll(){ // database'deki tüm kullanıcılar yazdırılır
		users.list();
	}
	
	public static int findEMail(String tempEMail) { // database'de belirtilen e-mail kayıtlı ise index'ini döner,
		// değilse -1 döner
		if (users.getUserList() == null) return -1;
		int count = 0;
		for (User user: users.getUserList()){
			if (user.getEMail().equals(tempEMail)) return count;
			count++;
		}
		return -1;
	}
	
	public static int findIdNo(String tempIdNo) { // database'de belirtilen kimlik numarası kayıtlı ise index'ini
		// döner, değilse -1 döner
		if (users.getUserList() == null) return -1;
		int count = 0;
		for (User user: users.getUserList()){
			if (user.getIdNo().equals(tempIdNo)) return count;
			count++;
		}
		return -1;
	}
	
	public static int findUserName(String tempUserName) { // database'de belirtilen kullanıcı adı kayıtlı ise index'ini
		// döner, değilse -1 döner
		if (users.getUserList() == null) return -1;
		int count = 0;
		for (User user: users.getUserList()){
			if (user.getUserName().equals(tempUserName)) return count;
			count++;
		}
		return -1;
	}
	
	public static boolean passwordMatches(String password, int userIndex){ // Giriş yapılırken şifre doğruluğu
		// kontrol eder
		return UserDataBase.getUsers()[userIndex].getPassword().equals(password);
	}
}