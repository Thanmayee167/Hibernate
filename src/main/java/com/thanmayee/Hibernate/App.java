package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Student student = new Student();

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		student = session.get(Student.class, 1);

		tx.commit();

		System.out.print(student);
	}
}
