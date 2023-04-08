package org.raspberry.auth.model.users;

import java.io.Serializable;

public class UserRolePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUser;

	private Long idRole;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

}
