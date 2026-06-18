package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Person;

public class Task7 {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
//		Person pr = new Person();
//		pr.setEmail("umang21@gmail.com");
//		pr.setName("umang");
//		pr.setAge(24);
//		
//		
//		Passport pt = new Passport();
//		pt.setCountry("India");
//		pt.setPassportNumber("IND1231234");
//		
//		pr.setPassport(pt);
//		pt.setPerson(pr); 
//		
//		s.persist(pr);
		
		Person pr = s.get(Person.class, 1);
		System.out.println(pr);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}

}
