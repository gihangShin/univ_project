package com.univ.app.model.comment;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Configuration
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentSeq;

	@Column(name = "BOARDSEQ")
	private Long boardSeq;

	@Column(name = "COMMENTWRITER")
	private String commentWriter;

	@Column(name = "COMMENTCONTENT")
	private String commentContent;

	@Column(name = "COMMENTLIKE")
	@ColumnDefault("0")
	private int commentLike;

	@CreatedDate
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime created_date;

	@LastModifiedDate
	@Column(name = "MODIFIED_DATE")
	private LocalDateTime modified_date;

	@Builder
	public Comment(Long board_seq, String comment_writer, String comment_content) {
		this.boardSeq = board_seq;
		this.commentWriter = comment_writer;
		this.commentContent = comment_content;
	}

	public Comment update(String comment_contnet, int comment_like) {
		this.commentContent = comment_contnet;
		this.commentLike = comment_like;
		return this;
	}
	
	@Override
	public String toString() {
		return "[comment seq "+commentSeq+", boardseq "+boardSeq+", writer "+commentWriter+", content "+commentContent+", like "+commentLike+"]";
	}
}
