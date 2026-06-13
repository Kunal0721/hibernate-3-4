package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dto.StudentNameWithRollno;

public class Task4 {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();

		Query<StudentNameWithRollno> q = 
				s.createQuery("select new StudentNameWithRollno(s.name, s.rollno) from Student s", StudentNameWithRollno.class);
		List<StudentNameWithRollno> ls = q.list();
		ls.stream().forEach(System.out::println);

		s.getTransaction().commit();
		s.close();
		sf.close();

	}
}
