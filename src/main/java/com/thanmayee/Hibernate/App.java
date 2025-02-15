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

		Session session = sf.openSession();

		session.beginTransaction();

		person = session.get(Person.class, 1);

		System.out.println(person);
		System.out.println(person.getLaptops());

		person = session.get(Person.class, 1);

		System.out.println(person);
		System.out.println(person.getLaptops());

		session.getTransaction().commit();
		session.close();
	}
}