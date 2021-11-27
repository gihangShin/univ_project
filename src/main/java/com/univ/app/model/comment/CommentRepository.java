package com.univ.app.model.comment;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByBoardSeq(long BoardSeq);

	@Query("UPDATE Comment c set c.commentLike = c.commentLike+1 where c.commentSeq = ?1")
	@Transactional
	@Modifying
	int updateCommentLike(long commentSeq);
}
