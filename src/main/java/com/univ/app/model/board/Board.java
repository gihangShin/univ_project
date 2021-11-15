package com.univ.app.model.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Configuration
public class Board {

//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long board_id;

	@Column(name = "BOARD_NUM")
	private Integer board_num; // 게시판 종류

	@Column(name = "BOARD_TITLE")
	private String board_title;

	@Column(name = "BOARD_WRITER")
	private String board_writer;

	@Column(name = "BOARD_CONTENT")
	private String board_content;

	@Builder
	public Board(String board_title, String board_writer, String board_content, int board_num) {
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_content = board_content;
	}

	public Board update(String board_title, String board_writer, String board_content, int board_num) {
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_content = board_content;
		return this;
	}

	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[BOARD"+board_id+" title : "+board_title+", writer : "+board_writer+", content : "+board_content+"]";
		}
	
}
