package com.twg.spring.mydiary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users") /*
						 * here we have written this table becuase calls name and database table name is
						 * different if same no need
						 */
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* this is for autoincrement for id because in database whe have given AI*/
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
