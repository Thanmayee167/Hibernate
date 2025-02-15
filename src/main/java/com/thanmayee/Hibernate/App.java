package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Person person;

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session1 = sf.openSession();

		session1.beginTransaction();

		person = session1.get(Person.class, 1);

		System.out.println(person);
		// System.out.println(person.getLaptops());

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();

		session2.beginTransaction();

		person = session2.get(Person.class, 1);

		System.out.println(person);
		// System.out.println(person.getLaptops());

		session2.getTransaction().commit();
		session2.close();

	}
}