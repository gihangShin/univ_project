package com.univ.app.model.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserServiceClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("univ-project");
		EntityManager em = emf.createEntityManager(); // CRUD 수행

		EntityTransaction tx = em.getTransaction();
		User user = User.builder().user_id("test:id").user_password("test:password").user_name("test:name")
				.user_email("test:email").build();

		try {
			tx.begin();

			em.persist(user); // 등록 insert

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}
}
