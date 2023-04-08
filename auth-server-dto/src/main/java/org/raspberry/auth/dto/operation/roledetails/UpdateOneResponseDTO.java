package org.raspberry.auth.dto.operation.roledetails;

import org.raspberry.auth.dto.model.roles.RoleDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOneResponseDTO {

	@JsonProperty("role_details")
	private RoleDetailsDTO roleDetails;

	public RoleDetailsDTO getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(RoleDetailsDTO roleDetails) {
		this.roleDetails = roleDetails;
	}

}
