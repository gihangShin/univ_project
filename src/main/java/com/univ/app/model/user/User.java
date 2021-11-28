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
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Configuration
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSeq;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_PASSWORD")
	private String userPassword;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Builder
	public User(Long user_seq, String user_id, String user_password, String user_name, String user_email) {
		this.userSeq = user_seq;
		this.userId = user_id;
		this.userPassword = user_password;
		this.userName = user_name;
		this.userEmail = user_email;
	}

	// 수정사항
	public User update(String user_password, String user_email) {
		this.userPassword = user_password;
		this.userEmail = user_email;
		return this;
	}

	@Override
	public String toString() {
		return "[ user : " + userSeq + ", " + userId + ", " + userPassword + ", " + userName + ", " + userEmail + "]";
	}

}
