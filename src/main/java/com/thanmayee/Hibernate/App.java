package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		StudentName studentName = new StudentName();
		studentName.setSname("Bukkittu");
		studentName.setFname("Sai");
		studentName.setLname("Thanmayee");

		Student student = new Student();
		student.setStudentId(1);
		student.setName(studentName);
		student.setAge(23);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.persist(student);

		tx.commit();

		System.out.print(student);
	}
}
