package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Book;
import entity.Library;

public class Task8 {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		
		Library lib = new Library();
		lib.setLibrarianName("Mr. Rakesh");
		
		List<Book> list = List.of(
					new Book("Java DSA", 890.67, lib),
					new Book("Ai Ml", 789.67, lib)
				);
		lib.setBooks(list);
		
		s.persist(lib);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
