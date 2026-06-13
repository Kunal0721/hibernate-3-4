package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Account;

public class Task3 {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		try {

			double amount = 1000;
			Account a = s.get(Account.class, 1);
			Account b = s.get(Account.class, 3);

			a.setBalance(a.getBalance() - amount);
			b.setBalance(b.getBalance() + amount);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		s.close();
		sf.close();

	}
}
