package com.univ.app.model.board;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("univ-project");
		EntityManager em = emf.createEntityManager(); // CRUD 수행

		EntityTransaction tx = em.getTransaction();
		Board board = Board.builder().board_title("test:title").board_writer("test:writer")
				.board_content("test:content").board_num(1).build();

		try {
			tx.begin();

			em.persist(board); // 등록 insert

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
