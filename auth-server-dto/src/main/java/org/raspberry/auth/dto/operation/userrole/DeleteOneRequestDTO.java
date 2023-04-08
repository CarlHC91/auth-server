package org.raspberry.auth.dto.operation.userrole;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.users.UserRoleDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteOneRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	@JsonProperty("user_role")
	private UserRoleDTO userRole;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

	public UserRoleDTO getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleDTO userRole) {
		this.userRole = userRole;
	}

}
