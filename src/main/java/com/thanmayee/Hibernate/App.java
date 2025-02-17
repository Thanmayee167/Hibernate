package com.thanmayee.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		int age = 10;
		Query query = session1.createQuery("Select sno,name,age from Person where age> :age");
		query.setParameter("age", age);
		List<Object[]> persons = (List<Object[]>) query.list();
		for (Object[] person : persons) {
			System.out.println("Person [sno=" + person[0] + ", name=" + person[1] + ", age=" + person[2] + "]");
		}

		session1.getTransaction().commit();
		session1.close();

	}
}