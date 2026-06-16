package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Student;

public class Task5 {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Query<Student> q = s.createQuery(" from Student where age=:age ", Student.class);
		q.setParameter("age", 19);

		q.list().stream().forEach(System.out::println);

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
