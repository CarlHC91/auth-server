package org.raspberry.auth.dto.operation.roledetails;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.roles.RoleDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOneRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	@JsonProperty("role_details")
	private RoleDetailsDTO roleDetails;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

	public RoleDetailsDTO getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(RoleDetailsDTO roleDetails) {
		this.roleDetails = roleDetails;
	}

}
