package pkg.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class Book_Manager {
	
	ObjectOutputStream oos_book=null;
	ObjectInputStream ois_book=null;
	
	File book_file =new File("Books.dat");
	
	ArrayList <Book> book_list =null;
	
	@SuppressWarnings("unchecked")
	public Book_Manager() {
		book_list = new ArrayList<Book>();
		if(book_file.exists())
		{
			try {
				ois_book =new ObjectInputStream(new FileInputStream(book_file));
			   book_list =(ArrayList<Book>) ois_book.readObject();
			   
			} 
			catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void listBookBySubject(String subject) {
		for(Book book: book_list) {
			if(book.getSubject().equals(subject))
				System.out.println(book);
		}
	}
	
	public void addBook(Book book) {
		book_list.add(book);
		
	}
	
	public void viewAllBook(){
		for(Book book:book_list)
		{
			System.out.println(book);
		}
	}
	public Book searchBookByIsbn(int search_isbn){
		for(Book book:book_list) {
			if(book.getIsnb()== search_isbn)
				return book;
		}
		return null;	
	}
	
	public boolean deleteBook(int delet_isbn) {
		ListIterator<Book> book_iterator = (ListIterator<Book>) book_list.listIterator();
		while(book_iterator.hasNext())
		{
			Book book= book_iterator.next();
			if(book.getIsnb()== delet_isbn)
			{
				book_list.remove(book);
				return true;
			}
		}
       return false;
	}
	
	public boolean updateBook(int update_isbn,String title, String author, String puplisher, int edition, String subject,
			int available_quantity) {
		ListIterator<Book> book_iterator = (ListIterator<Book>) book_list.listIterator();
		while(book_iterator.hasNext())
		{
			Book book= book_iterator.next();
			if(book.getIsnb()== update_isbn)
			{
				book.setAuthor(author);
				book.setAvailable_quantity(available_quantity);
				book.setEdition(edition);
				book.setPuplisher(puplisher);
				book.setSubject(subject);
				book.setTitle(title);
				return true;
			}
			
		}
       return false;
	}
	
	public void writeTofile() {
		try {
			oos_book =new ObjectOutputStream(new FileOutputStream(book_file));
		     oos_book.writeObject(book_list);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
   }
			
	
}	
	
	


