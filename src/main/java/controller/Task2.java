package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Doctor;
import entity.Gender;

public class Task2 {
	public static void main(String[] sandeep) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Doctor dr = new Doctor("Dr. Rohit", 35, Gender.MALE, "rohit34@gmail.com", "9340078246");
		s.persist(dr);

		s.getTransaction().commit();
		s.close();
		sf.close();

	}
}
