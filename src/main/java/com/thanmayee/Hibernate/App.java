package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		Person person;

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session1 = sf.openSession();

		session1.beginTransaction();

		Query q1 = session1.createQuery("from Person where sno=1");
		q1.setCacheable(true);
		person = (Person) q1.uniqueResult();
		System.out.println(person);
		// System.out.println(person.getLaptops());

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();

		session2.beginTransaction();

		Query q2 = session2.createQuery("from Person where sno=1");
		q2.setCacheable(true);
		person = (Person) q2.uniqueResult();
		System.out.println(person);
		// System.out.println(person.getLaptops());

		session2.getTransaction().commit();
		session2.close();

	}
}