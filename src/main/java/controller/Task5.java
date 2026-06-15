package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Person;

public class Task5 {
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
//		List<Person> list = s.createQuery("from person", Person.class).list();
//		list.stream().forEach(a -> System.out.println(a));
	
		Person pr = s.get(Person.class, 2);
		s.remove(pr);
			
		s.getTransaction().commit();
		s.close(); 
		sf.close();
	}
}
