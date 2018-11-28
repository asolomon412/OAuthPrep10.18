package com.oauthdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Used internally by GithubService.
 */
@Entity
@Table(name = "user")
public class GithubUser {
	@Id
	private Long id;
	private String name;
	@Column(name = "username")
	private String login;
	private String avatar_url;
	private String password;



	public GithubUser() {
		// TODO Auto-generated constructor stub
	}

	public GithubUser(Long id, String name, String login, String avatar_url) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.avatar_url = avatar_url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}