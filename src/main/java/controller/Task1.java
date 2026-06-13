package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class Task1 {
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
//		Student st = new Student("Raj", 21, 112);
//		s.persist(st);
		
//		List<Student> list = List.of(new Student("ritik", 19, 111), 
//				new Student("shivani", 19, 113), 
//				new Student("vikas", 21, 114), 
//				new Student("bhumi", 19, 115), 
//				new Student("rishab", 21, 116)
//				);
//		
//		list.stream().forEach(a -> s.persist(a));
		
		// Employee -> id, name, age, salary, email  (CRUD) 
		
		Student st = s.get(Student.class, 4);
		// st.setAge(22);
		s.remove(st);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
