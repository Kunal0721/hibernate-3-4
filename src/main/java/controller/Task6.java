package controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Customers;

public class Task6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Query<Customers> q = s.createQuery("from Customers", Customers.class);
		
		int count = 0;
		boolean f = true;
		while (f) {
			System.out.println();
			System.out.println("Enter 1 for next 10 data or enter 0 for exit..");
			int choice = sc.nextInt();
			if (choice == 1) {
				q.setMaxResults(10);
				q.setFirstResult(count);
				count += 10;
				q.list().stream().forEach(System.out::println);
			} else {
				f = false;
				System.out.println("exit...");
			}
		}

//		q.setMaxResults(10);
//		q.setFirstResult(10);
//		q.list().stream().forEach(System.out::println);

		s.getTransaction().commit();
		s.close();
		sf.close();
		sc.close();
	}
}
