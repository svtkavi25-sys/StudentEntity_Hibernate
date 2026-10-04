package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration c=new Configuration();
		c.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		c.setProperty("hibernate.connection.url","jdbc:mysql://db01.dbhost.dev:5051/db_453kjvma4");
		c.setProperty("hibernate.connection.username","user_453kjvma4");
		c.setProperty("hibernate.connection.password","p453kjvma4");
		c.setProperty("hibernate.hbm2ddl.auto","update");
		c.setProperty("hibernate.show_sql","true");
		c.setProperty("hibernate.format_sql","true");
		c.addAnnotatedClass(Student.class);
		SessionFactory factory=c.buildSessionFactory();
		Session session=factory.openSession();
		Student s=new Student(101,"Kavi","kavi@email.com","Information Technology");
		Student s1=new Student(102, "Kanishka","kaniska@gmail.com","AIDS");
		Student s2=new Student(103,"kaviya","kaviya@gmail.com", "CSE");
		session.beginTransaction();
		session.persist(s); 
		session.persist(s1);
		session.persist(s2);
		session.getTransaction().commit();
		System.out.println("Students data are inserted");
		session.beginTransaction();
		Student student=session.get(Student.class,101); 
		student.setName("Kavi S V");
		student.setEmail("kavisv@gmail.com");
		student.setCourse("IT");
		session.getTransaction().commit();
		System.out.println("Updated successfully");
	}

}
