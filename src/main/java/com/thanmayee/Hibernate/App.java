package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Student student = new Student();
		student.setName("Sai");
		student.setAge(23);

		Configuration con = new Configuration();

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		session.persist(student);
	}
}
