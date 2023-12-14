package pkg.person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable {
	
	protected String name;
	protected String emailId;
	protected String phoneNum;
	protected String address;
	protected String dob;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		boolean isValidname =Pattern.matches("[a-z A-Z]+", name);
		if(isValidname)
		   this.name = name;
		else
			this.name= "Default name";
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		boolean isValiddob = Pattern.matches("\\d(2)-\\d(2)-\\d(4)", dob);
		if(isValiddob)
		   this.dob = dob;
		else
			this.dob = "01-01-2000";
	}
	public Person(String name, String emailId, String phoneNum, String address, String dob) {
		super();
		this.setName(name);
		this.emailId = emailId;
		this.phoneNum = phoneNum;
		this.address = address;
		this.setDob(dob);
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
