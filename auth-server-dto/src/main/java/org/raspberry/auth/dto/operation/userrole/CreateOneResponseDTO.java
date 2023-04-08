package org.raspberry.auth.dto.operation.userrole;

import org.raspberry.auth.dto.model.users.UserRoleDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOneResponseDTO {

	@JsonProperty("user_role")
	private UserRoleDTO userRole;

	public UserRoleDTO getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleDTO userRole) {
		this.userRole = userRole;
	}

}
