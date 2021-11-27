package com.univ.app.model.board;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
	Board findByBoardSeq(long BoardSeq);
	
	@Query("UPDATE Board b set b.boardLike = b.boardLike+1 where b.boardSeq = ?1")
	@Transactional
	@Modifying
	int updateBoardLike(long boardSeq);
}
