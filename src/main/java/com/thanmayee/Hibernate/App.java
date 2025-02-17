package com.thanmayee.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration con = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Laptop.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session1 = sf.openSession();

		session1.beginTransaction();

//		insert values
//		Random random = new Random();
//		for (int i = 1; i <= 10; i++) {
//			Person person = new Person();
//			person.setSno(i + 1);
//			person.setName("Name" + i);
//			person.setAge(random.nextInt(100));
//			session1.persist(person);
//		}

//		fetches list of persons
//		Query query = session1.createQuery("from Person");
//		List<Person> persons = query.list();
//		for (Person person : persons) {
//			System.out.println(person);
//		}

// 		fetches specific record
//		Query query = session1.createQuery("from Person where sno=10");
//		Person person = (Person) query.uniqueResult();
//		System.out.println(person);

// 		fetches specific record using Select query
//		Query query = session1.createQuery("Select sno,name,age from Person where sno=10");
//		Object[] person = (Object[]) query.uniqueResult();
//		System.out.println("Person [sno=" + person[0] + ", name=" + person[1] + ", age=" + person[2] + "]");

//		fetches records that contains age>10
//		Query query = session1.createQuery("Select sno,name,age from Person where age>10");
//		List<Object[]> persons = (List<Object[]>) query.list();
//		for (Object[] person : persons) {
//			System.out.println("Person [sno=" + person[0] + ", name=" + person[1] + ", age=" + person[2] + "]");
//		}

// 		fetches average age of all the records
//		Query query = session1.createQuery("Select AVG(age) from Person");
//		Double averageMarks = (Double) query.uniqueResult();
//		System.out.println("Average marks=" + averageMarks);

//		fetches records that contains age>10
//		int age = 10;
//		Query query = session1.createQuery("Select sno,name,age from Person where age> :age");
//		query.setParameter("age", age);
//		List<Object[]> persons = (List<Object[]>) query.list();
//		for (Object[] person : persons) {
//			System.out.println("Person [sno=" + person[0] + ", name=" + person[1] + ", age=" + person[2] + "]");
//		}

//		fetches all records from person table
//		NativeQuery<Person> query = session1.createNativeQuery("SELECT * FROM person", Person.class);
//		List<Person> persons = query.list();
//
//		for (Person person : persons) {
//			System.out.println(person);
//		}

		// Example to demonstrate hibernate object states
		Person person = new Person();
		person.setSno(13);
		person.setName("Geetha");
		person.setAge(59);// Object is in Transient state

		session1.persist(person);
		person.setAge(55);// Object is in persistent state

		session1.getTransaction().commit();

		session1.detach(person);
		person.setAge(60);// Object is in Detached state;

		// Reattach before removing
		session1.beginTransaction();
		Person managedPerson = session1.merge(person); // Reattach entity
		session1.remove(managedPerson); // Now remove it
		session1.getTransaction().commit();

		session1.close();
	}
}