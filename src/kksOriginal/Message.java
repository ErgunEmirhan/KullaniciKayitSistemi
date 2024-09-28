package kksOriginal;

import java.time.LocalDate;

public class Message {
	
	protected int id;
	protected String receiver;
	protected String sender;
	protected String content;
	protected LocalDate sendDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public LocalDate getSendDate() {
		return sendDate;
	}
	
	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}
	
	@Override
	public String toString() {
		return "kksOriginal.Message{" + "id=" + getId() + ", receiver='" + getReceiver() + '\'' + ", sender='" + getSender() + '\'' + ", content='" + getContent() + '\'' + ", sendDate=" + getSendDate() + '}';
	}
}