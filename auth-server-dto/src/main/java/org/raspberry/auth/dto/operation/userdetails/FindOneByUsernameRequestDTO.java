package org.raspberry.auth.dto.operation.userdetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByUsernameRequestDTO {

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;

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
