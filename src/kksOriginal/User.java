package kksOriginal;

import java.time.LocalDate;

public class User {
	
	private static int nextUserId;
	private int userId;
	private String idNo;
	private String name;
	private String surname;
	private String eMail;
	private String phoneNumber;
	private String userName;
	private String password;
	private LocalDate birthday;
	private LocalDate registrationDate;
	
	public User(){}
	public User(LocalDate birthday, String password, String userName, String phoneNumber, String eMail, String surname, String name, String idNo) {
		this.birthday = birthday;
		this.password = password;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.surname = surname;
		this.name = name;
		this.idNo = idNo;
		this.userId = nextUserId++;
		this.registrationDate = LocalDate.now();
	}
	
	public static int getNextUserId() {
		return nextUserId;
	}
	
	public static void setNextUserId(int nextUserId) {
		User.nextUserId = nextUserId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getIdNo() {
		return idNo;
	}
	
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Override
	public String toString() {
		return "kksOriginal.User{" + "userId=" + getUserId() + ", idNo='" + getIdNo() + '\'' + ", name='" + getName() + '\'' + ", surname='" + getSurname() + '\'' + ", eMail='" + getEMail() + '\'' + ", phoneNumber='" + getPhoneNumber() + '\'' + ", userName='" + getUserName() + '\'' + ", password='" + getPassword() + '\'' + ", birthday=" + getBirthday() + ", registrationDate=" + getRegistrationDate() + '}';
	}
}