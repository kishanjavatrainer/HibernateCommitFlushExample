package com.infotech.client;

import java.math.BigInteger;

import org.hibernate.Session;

import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class CommitFlushOnSQLTest {


	public static void main(String[] args) {

		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			Person  person = new Person();
			person.setFirstName("Gavin");
			person.setLastName("King");
			
			session.beginTransaction();
			
			session.save(person);
			session.getTransaction().commit();
		 BigInteger count=(BigInteger)	session .createNativeQuery("select count(*) from Person")
		    .getSingleResult();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}