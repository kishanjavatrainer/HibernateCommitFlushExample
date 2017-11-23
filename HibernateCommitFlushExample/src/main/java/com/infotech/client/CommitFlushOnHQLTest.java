package com.infotech.client;

import javax.persistence.FlushModeType;

import org.hibernate.Session;

import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class CommitFlushOnHQLTest {


	public static void main(String[] args) {

		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			Person  person = new Person();
			person.setFirstName("Gavin");
			person.setLastName("King");
			
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
			session.createQuery("select p from Advertisement p")
		    .setFlushMode( FlushModeType.COMMIT)
		    .getResultList();

			 session.createQuery("select p from Person p")
		    .setFlushMode( FlushModeType.COMMIT)
		    .getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}