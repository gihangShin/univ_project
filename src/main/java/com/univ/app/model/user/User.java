package com.univ.app.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
@Configuration
@Table(name = "USER")
public class User{

//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_num;

	@Column(name = "USER_ID")
	private String user_id;

	@Column(name = "USER_PASSWORD")
	private String user_password;

	@Column(name = "USER_NAME")
	private String user_name;

	@Column(name = "USER_NICKNAME")
	private String user_nickname;

	@Column(name = "USER_EMAIL")
	private String user_email;

	@Builder
	public User(Long user_num, String user_id, String user_password, String user_name, String user_nickname,
			String user_email) {
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
	}

	public User update(String user_password, String user_nickname, String user_email) {
		this.user_password = user_password;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		return this;
	}

}
