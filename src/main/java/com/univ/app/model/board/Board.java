package com.univ.app.model.board;

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
public class Board {

//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardSeq;

	@Column(name = "fileName")
	@ColumnDefault("null")
	private String fileName;

	@Column(name = "fileOriName")
	@ColumnDefault("null")
	private String fileOriName;

	@Column(name = "fileUri")
	@ColumnDefault("null")
	private String fileUri;

	@Column(name = "BOARDTITLE")
	private String boardTitle;

	@Column(name = "BOARDWRITER")
	private String boardWriter;

	@Column(name = "BOARDCONTENT")
	private String boardContent;

	@Column(name = "BOARDLIKE")
	@ColumnDefault("0")
	private int boardLike;

	@CreatedDate
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime created_date;

	@LastModifiedDate
	@Column(name = "MODIFIED_DATE")
	private LocalDateTime modified_date;

	@Builder
	public Board(String filename, String fileOriName, String fileuri, String board_title, String board_writer,
			String board_content, int board_like) {
		this.fileName = filename;
		this.fileOriName = fileOriName;
		this.fileUri = fileuri;
		this.boardTitle = board_title;
		this.boardWriter = board_writer;
		this.boardContent = board_content;
		this.boardLike = board_like;
	}

	// 수정 사항
	// 파일, 제목, 내용, like수
	public Board update(String filename, String fileOriName, String fileuri, String board_title, String board_content,
			int board_like) {
		this.fileName = filename;
		this.fileOriName = fileOriName;
		this.fileUri = fileuri;
		this.boardTitle = board_title;
		this.boardContent = board_content;
		this.boardLike = board_like;
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[BOARD" + boardSeq + " filename : " + fileName + ", fileOriname : " + fileOriName + ", fileuri : "
				+ fileUri + ", title : " + boardTitle + ", writer : " + boardWriter + ", content : " + boardContent
				+ "]";
	}

}
