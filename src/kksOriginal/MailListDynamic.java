package kksOriginal;

import java.util.Arrays;

public class MailListDynamic {
	
	private int nextIndex = 1;
	private Mail[] mailList;
	
	
	public Mail[] getMailList() {
		return mailList;
	}
	
	public void setMailList(Mail[] mailList) {
		this.mailList = mailList;
	}
	
	public void add(Mail newUser){
		Mail[] tempList = new Mail[nextIndex];
		for (int i = 0; i < nextIndex-1; i++) {
			tempList[i] = mailList[i];
		}
		tempList[nextIndex-1] = newUser;
		mailList = tempList;
		nextIndex++;
	}
	
	public void remove(int mailIndex){
		if(mailIndex < 0 || mailIndex >= nextIndex) System.out.println("Cannot reach the index.");
		else {
			for (int i = mailIndex; i < nextIndex-1; i++) {
				mailList[mailIndex] = mailList[mailIndex+1];
			}
			mailList = Arrays.copyOfRange(mailList, 0, --nextIndex);
		}
	}
	
	public void list(){
		for (Mail mail: mailList){
			System.out.println(mail);
		}
	}
}