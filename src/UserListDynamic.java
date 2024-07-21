import java.util.Arrays;

public class UserListDynamic {
	
	private int nextIndex = 1;
	private User[] userList;
	
	
	public User[] getUserList() {
		return userList;
	}
	
	public void setUserList(User[] userList) {
		this.userList = userList;
	}
	
	public void add(User newUser){
		User[] tempList = new User[nextIndex];
		for (int i = 0; i < nextIndex-1; i++) {
			tempList[i] = userList[i];
		}
		tempList[nextIndex-1] = newUser;
		userList = tempList;
		nextIndex++;
	}
	
	public void remove(int userIndex){
		if(userIndex < 0 || userIndex >= nextIndex) System.out.println("Cannot reach the index.");
		else {
			for (int i = userIndex; i < nextIndex-1; i++) {
				userList[userIndex] = userList[userIndex+1];
			}
			userList = Arrays.copyOfRange(userList, 0, --nextIndex);
		}
	}
	
	public void list(){
		for (User user: userList){
			System.out.println(user);
		}
	}
}