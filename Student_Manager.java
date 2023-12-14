package pkg.person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class Student_Manager {
	ObjectOutputStream oos_student=null;
	ObjectInputStream ois_student=null;
	
	File student_file = null;
	
	ArrayList<Student> student_list=null;
	
	@SuppressWarnings("unchecked")
	public Student_Manager() {
		student_file =new File("Student.dat");
		student_list =new ArrayList<Student>();
		
		if(student_file.exists())
		{
			try {
			ois_student =new ObjectInputStream(new FileInputStream(student_file));
			student_list =(ArrayList<Student>) ois_student.readObject();
			}
			catch (IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		  }
		}
	public void addStudent(Student student) {
		student_list.add(student);
	}
	public Student get(int rollNo) {
		for(Student student: student_list) {
			if (student.getRollNo()== rollNo)
				return student;
		}
		return null;
	}
	
	public void viewAllStudent() {
		for(Student student: student_list)
			System.out.println(student);
	}
	
	public boolean deletStudent(int delete_rollNo) {
		ListIterator<Student> student_iterator=(ListIterator<Student>) student_list.listIterator();
	 while(student_iterator.hasNext()) {
		Student student=student_iterator.next();
		if(student.getRollNo()== delete_rollNo) {
			student_list.remove(student);
			return true;
		}
	 }
	 return false;
	 
	}
	public boolean updateStudent(int update_rollNo,String name, String emailId, String phoneNum, String address, String dob,  int std,
			int division) {
		ListIterator<Student> student_iterator =(ListIterator<Student>)student_list.listIterator(); 
		 while(student_iterator.hasNext()) {
			Student student=student_iterator.next();
			if(student.getRollNo()== update_rollNo) 
			{
				student.setAddress(address);
				student.setDivision(division);
				student.setDob(dob);
				student.setEmailId(emailId);
				student.setName(name);
				student.setPhoneNum(phoneNum);
				student.setStd(std);
				return true;
				
			}
	  }
		 return  false;
  }
	public void writeToFile() {
		try {
			oos_student =new ObjectOutputStream( new FileOutputStream(student_file));
		    oos_student.writeObject(student_list);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
	
	


