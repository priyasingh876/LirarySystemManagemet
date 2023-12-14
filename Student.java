package pkg.person;

public class Student extends Person {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int rollNo;
	private int std;
	private int division;
	
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getDivision() {
		return division;
	}
	public void setDivision(int division) {
		this.division = division;
	}
	
	public Student(String name, String emailId, String phoneNum, String address, String dob, int rollNo, int std,
			int division) {
		super(name, emailId, phoneNum, address, dob);
		this.rollNo = rollNo;
		this.std = std;
		this.division = division;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", std=" + std + ", division=" + division + ", name=" + name + ", emailId="
				+ emailId + ", phoneNum=" + phoneNum + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	
	
	

}
