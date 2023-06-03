package org.raspberry.auth.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_AUTHORITY")
public class UserAuthority {

	@Id
	@Column(name = "ID_AUTHORITY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAuthority;

	@Column(name = "ID_USER")
	private Long idUser;

	@Column(name = "NAME")
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
