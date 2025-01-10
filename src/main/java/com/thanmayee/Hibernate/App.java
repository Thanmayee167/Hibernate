package com.thanmayee.Hibernate;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Laptop laptop = new Laptop();
		laptop.setLno(1);
		laptop.setName("Dell");

		Person person = new Person();
		person.setSno(1);
		person.setName("Sai");
		person.setAge(23);
		person.setLaptops(Collections.singletonList(laptop));
		laptop.setPersons(Collections.singletonList(person));

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.persist(laptop);

		session.persist(person);

		tx.commit();

		System.out.print(person);
		System.out.print(laptop);
	}
}