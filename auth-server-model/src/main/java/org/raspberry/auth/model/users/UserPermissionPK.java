package org.raspberry.auth.model.users;

import java.io.Serializable;

public class UserPermissionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idUser;

	private Long idPermission;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

}
