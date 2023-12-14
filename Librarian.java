package pkg.person;

public class Librarian extends Person {
	private int id;
	private String doj;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", doj=" + doj + ", name=" + name + ", emailId=" + emailId + ", phoneNum="
				+ phoneNum + ", address=" + address + ", dob=" + dob + "]";
	}
	public Librarian(String name, String emailId, String phoneNum, String address, String dob, int id, String doj) {
		super(name, emailId, phoneNum, address, dob);
		this.id = id;
		this.doj = doj;
	}
	public Librarian() {
		super();
	}
	

}
