package pkg.main;

import java.util.Scanner;

import pkg.book.Book;
import pkg.book.Book_Manager;
import pkg.exception.BookNotFoundException;
import pkg.exception.StudentNotFoundException;
import pkg.person.Student;
import pkg.person.Student_Manager;
import pkg.transaction.Book_TransManager;

public class Main {
	
	public static void main(String[] arg)  {
		int choice;
		Scanner sc=new Scanner(System.in);
		
		Book_Manager bm = new Book_Manager();
		Student_Manager sm =new Student_Manager();
		Book_TransManager btm = new Book_TransManager();
		
		do {
			
			System.out.println("Please Enter 1 if You Are a Student \n Please Enter 2 if You Are a Librarian \n Enter 3 if You Want to exit! ");
		    choice =sc.nextInt();
		    
		    if(choice == 1)   //if user is student
		    {
		    	System.out.println("Enter your RollNo : ");
		    	int rollNo = sc.nextInt();
		    	try {
		    		Student s= sm.get(rollNo);
		    		if (s== null)
		    			throw new StudentNotFoundException();
		    		int stud_choice;
		    		
		    		do {
		    			System.out.println("Enter 1 to View All Books \n Enter 2 to Search Any Book by ISBN \n Enter 3 to ListBooks  by Subjects \n Enter 4 to Issue a Book \n Enter 5 to Return a Book \n Enter 0 For Exit..!");
		    			stud_choice = sc.nextInt();
		    			switch(stud_choice) {
		    			
		    			case 1:
		    			    System.out.println("All the Book Records Are..");
		    				bm.viewAllBook();
		    			    break;
		    			    
		    			case 2:
		    				//System.out.println("Please Enter ISBN to Search");
		    				System.out.println("Enter ISBN of the Book to Search ");
				    		int search_isbn =sc.nextInt();
				    		Book book=bm.searchBookByIsbn(search_isbn);
				    		if(book == null)
				    			System.out.println("No Book Find With ISBN Exists in Our Library");
				    		else
				    			System.out.println(book);
		    				break;
		    				
		    			case 3:
		    				System.out.println("Please Enter the Subject to Search");
		    				sc.nextLine();
		    				String search_subject =sc.nextLine();
		    				bm.listBookBySubject(search_subject);
		    				break;
		    				
		    			case 4:
		    				System.out.println("Enter the ISBN to Issue a Book");
		    				int issue_isbn=sc.nextInt();
		    				 book =bm.searchBookByIsbn(issue_isbn);
		    				 try {
		    				 if(book ==null) {
		    					 throw  new BookNotFoundException();
		    				     }
		    				 if (book.getAvailable_quantity()>0)
		    				 {
		    			     	if(btm.issueBook(rollNo, issue_isbn)) {
		    						book.setAvailable_quantity(book.getAvailable_quantity()-1);
		    						System.out.println("Book Has  been Issued..!");		    					
		    						}
		    				 }
		    					 
		    				 else {
		    					 System.out.println("The Book Has Been Issued..!");
		    				 }
		    					 }
		    				 
		    				 catch(BookNotFoundException  bnfe) {
		    					 System.out.println(bnfe);
		    				 }
		    				break;
		    				
		    			case 5://for return book  by  students
		    				
		    				System.out.println("Please Enter the ISbn to Return of Book");
		    				int  return_isbn =sc.nextInt();
		    				book =bm.searchBookByIsbn(return_isbn);
		    				if(book!=null) {
		    				if(btm.returnBook(rollNo,return_isbn)) {
		    					book.setAvailable_quantity(book.getAvailable_quantity()+1);
		    				   System.out.println("Thank You For Returning the Book..!");
		    				  }
		    				else {
		    					System.out.println("Could Not Return the Book");
		    				 }
		    				}
		    				else {
		    					System.out.println("Book With the ISBN Does Not Exists");	
		    				}
		    				
		    				break;
		    			case 0:
		    				System.out.println("Thank You For Using  Library..!");
		    				break;
		    			default :
		    				System.out.println("Invalid Choice.... Enter Correct Number");
		    				
		    			}
		    			
		    		}while(stud_choice != 3);
		    	}
		    	catch(StudentNotFoundException snfe)
		    	{
		    		System.out.println(snfe);
		    	}
		    }
		   
		    else if (choice ==2)   //if user is a Librarian
		    {
		    	int lib_choice;
		    
		    	do{
		    		
		    	System.out.println("Enter 11 to View All Students \n Enter 12 to Print a Student by Rollno \n Enter 13 to Register a Student \n Enter 14 to Update a Student Details \n Enter 15 to Delete Student's Details or Account");
		     	System.out.println("Enter 21 to View All Books \n Enter 22 to Print a Book by ISBN \n Enter 23 to Add a New Book \n Enter 24 to Update a Book Details \n Enter 25 to Delete Book's Details ");
		    	System.out.println("Enter 31 to View All Transaction \n Enter 0 to Exit");
		    	lib_choice = sc.nextInt();
		    	switch(lib_choice) {
		    	case 11:   //View all students 
		    		System.out.println("All the Student's Records");
		    		sm.viewAllStudent();
		    		break;
		    		
		    	case 12:   //search a student based no rollno
		    		System.out.println("Enter Roll Number to Fatch Student's Record");
		    		int get_rolNo =sc.nextInt();
		    		Student student =sm.get(get_rolNo);
		    		if (student == null) {
		    			System.out.println("No Record Matches to this Roll Number");
		    		}
		    		else
		    			System.out.println(student);
		    		break;
		    		
		    	case 13:   //adding or registering student's
		    		System.out.println("Enter Student's details to add");
		    		String name ;
		    		String emailId;
		    		String phoneNum;
		    		String address;
		    		String dob ;
		    		int rollNo;
		    		int std;
		    		int division;
		    		
		    		sc.nextLine();
		    		System.out.println("Enter Name:");
		    		name=sc.nextLine();
		    		System.out.println("Enter EmailId:");
		    		emailId=sc.nextLine();
		    		System.out.println("Enter Phone Number :");
		    		phoneNum=sc.nextLine();
		    		System.out.println("Enter Address:");
		    		address=sc.nextLine();
		    		System.out.println("Enter Dob:");
		    		dob=sc.nextLine();
		    		System.out.println("Enter Roll No:");
		    		rollNo=sc.nextInt();
		    		System.out.println("Enter standard:");
		    		std=sc.nextInt();
		    		System.out.println("Enter Division:");
		    		division=sc.nextInt();
		    		
		    		 student = new Student( name, emailId, phoneNum,address, dob, rollNo, std,division);
		    		 sm.addStudent(student);
		    		 System.out.println("Student is Added..!");
		    		 break;	
		    		 
		    	case 14:   //for update students details
		    		System.out.println("Enter the RollNo to Modify the Records ");
		    		int modify_rollNo;
		    		modify_rollNo = sc.nextInt();
		    		student =sm.get(modify_rollNo);
		    		
		    		try {
		    		if(student == null)
		    		throw new StudentNotFoundException();
		    		
		    		sc.nextLine();
		    		System.out.println("Enter Name:");
		    		name=sc.nextLine();
		    		System.out.println("Enter EmailId:");
		    		emailId=sc.nextLine();
		    		System.out.println("Enter Phone Number :");
		    		phoneNum=sc.nextLine();
		    		System.out.println("Enter Address:");
		    		address=sc.nextLine();
		    		System.out.println("Enter Dob:");
		    		dob=sc.nextLine();
		    		
		    		System.out.println("Enter Standard:");
		    		std=sc.nextInt();
		    		System.out.println("Enter Division:");
		    		division=sc.nextInt();
		    		
		    		sm.updateStudent(modify_rollNo, name, emailId, phoneNum, address, dob, std, division);
		    		System.out.println("Student Records is Updated");
		    		}
		    		catch(StudentNotFoundException snfe) {
		    			System.out.println(snfe);
		    		}
		    		break;
		    		
		    	case 15:   //for  deleting student's details
		    		System.out.println("Enter RollNo For Deleting Records");
		    		int delete_rollNo;
		    		delete_rollNo =sc.nextInt();
		    		if(sm.deletStudent(delete_rollNo))
		    			System.out.println("Student Record is Removed");
		    		else
		    			System.out.println("No Records With Given RollNo Exists");
		    		break;
		    		
		    	case 21:   // for view all books
		    		bm.viewAllBook();
		    		break;
		    		
		    	case 22:  //Search a book by ISBN 
		    		int search_isbn;
		    		System.out.println("Enter ISBN of the Book to Search ");
		    		search_isbn =sc.nextInt();
		    		Book book=bm.searchBookByIsbn(search_isbn);
		    		if(book == null)
		    			System.out.println("No Book Find With ISBN Exists in Our Library");
		    		else
		    			System.out.println(book);
		    		break;
		    		
		    	case 23: //add a book into library
		    		System.out.println("Please Enter Book Details to Add");
		    		 int isnb;
		    		 String title;
		    		 String author;
		    	     String puplisher;
		    		 int edition;
		    		 String subject;
		    		 int available_quantity;
		    		 System.out.println("ISBN:");
		    		 isnb=sc.nextInt();
		    		 
		    		 sc.nextLine();
		    		 System.out.println("Title:");
		    		 title=sc.nextLine();
		    		 
		    		 System.out.println("Author:");
		    		 author=sc.nextLine();
		    		 
		    		 System.out.println("Publisher:");
		    		 puplisher=sc.nextLine();
		    		 
		    		 System.out.println("Edition:");
		    		 edition=sc.nextInt();
		    		 
		    		 sc.nextLine();
		    		 System.out.println("Subject:");
		    		 subject=sc.nextLine();
		    		 
		    		 System.out.println("Quantity:");
		    		 available_quantity=sc.nextInt();
		    		 
		    		 book= new Book(isnb, title, author, puplisher, edition, subject,
		    				 available_quantity);
		    		 bm.addBook(book); 
		    		 System.out.println("A Book Record is Added..!");
		    	
		    		 break;
		    		  
		    	case 24:  // for update a book record
		    		System.out.println("Please Enter the ISBN to Update the Record");
		    		int update_isbn;
		    		update_isbn =sc.nextInt();
		    		try {
		    			book = bm.searchBookByIsbn(update_isbn);
		    			if(book == null)
		    				throw new  BookNotFoundException();
		    		    
		    			System.out.println("Enter Book Details to Modify");
			    		 
			    		 sc.nextLine();
			    		 System.out.println("Title:");
			    		 title=sc.nextLine();
			    		 
			    		 System.out.println("Author:");
			    		 author=sc.nextLine();
			    		 
			    		 System.out.println("Publisher:");
			    		 puplisher=sc.nextLine();
			    		 
			    		 System.out.println("Edition:");
			    		 edition=sc.nextInt();
			    		 
			    		 sc.nextLine();
			    		 System.out.println("Subject:");
			    		 subject=sc.nextLine();
			    		 
			    		 System.out.println("Quantity:");
			    		 available_quantity=sc.nextInt();
			    		 
			    		 bm.updateBook(update_isbn,title, author, puplisher, edition, subject,
		    				 available_quantity);
			    		 
		    		}
		    		catch(BookNotFoundException bnfe) {
		    			System.out.println(bnfe);
		    			
		    		}
		    		break;
		    		
		    	case 25: //for deleting book records
		    		System.out.println("Please Enter the ISBN to Delete the Record");
		    		int delete_isbn;
		    		delete_isbn =sc.nextInt();
		    		try {
		    			book = bm.searchBookByIsbn(delete_isbn);
		    			if(book == null)
		    				throw new  BookNotFoundException();
		    			bm.deleteBook(delete_isbn);
		    		}
		    		catch (BookNotFoundException bnfe) {
		    			System.out.println(bnfe);
		    			System.out.println("Book Record Deleted..!");
		    		}
		    		break;
		    		
		    	case 31:  //for view all transaction  records
		    		System.out.println("Show All the Transactions Are..!");
		    		btm.showAll();
		    		
		    	case 0:
		    		System.out.println("Thank You For Using  Library..!");
    				break;
    			default :
    				System.out.println("Invalid Choice.... Enter Correct Number");
		    	}	
		    		
		       }while(lib_choice !=0);	
		    }
		    
		}while(choice != 3);
		sm.writeToFile();
		bm.writeTofile();
		btm.writeTofile();
		sc.close();
		
	}

}
