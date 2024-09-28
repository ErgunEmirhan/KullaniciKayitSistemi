package kksOriginal;

public class MailDataBase {
	
	private static MailListDynamic mails = new MailListDynamic();
	
	public static void sendMail(String sender, String receiver, String title, String content){
		mails.add(new Mail(receiver, sender, title, content));
	}
	
	public static void sendAll(String sender, String title, String content, String... receivers){
		for (String receiver:receivers){
			sendMail(sender, receiver, title, content);
		}
	}
	
	public static Mail[] getMails(){
		return mails.getMailList();
	}
	
	public static void showAllMails(){
		mails.list();
	}
	
	
}