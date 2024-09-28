package kksRefactored;

import java.time.LocalDate;

public class Mail extends Message {
	
	private static int nextMailId;
	
	private String title;
	
	
	public Mail(String receiver, String sender, String title, String content) {
		this.id = nextMailId++;
		this.receiver = receiver;
		this.sender = sender;
		this.title = title;
		this.content = content;
		this.sendDate = LocalDate.now();
	}
	
	
}