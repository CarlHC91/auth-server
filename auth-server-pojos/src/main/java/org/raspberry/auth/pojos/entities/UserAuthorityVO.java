package org.raspberry.auth.pojos.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAuthorityVO {

	@JsonProperty("id_authority")
	private Long idAuthority;

	@JsonProperty("id_user")
	private Long idUser;

	@JsonProperty("name")
	private String name;

	public Long getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Long idAuthority) {
		this.idAuthority = idAuthority;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}