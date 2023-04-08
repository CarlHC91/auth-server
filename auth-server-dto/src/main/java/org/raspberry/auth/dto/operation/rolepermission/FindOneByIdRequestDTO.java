package org.raspberry.auth.dto.operation.rolepermission;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.roles.RolePermissionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByIdRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	@JsonProperty("role_permission")
	private RolePermissionDTO rolePermission;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

	public RolePermissionDTO getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(RolePermissionDTO rolePermission) {
		this.rolePermission = rolePermission;
	}

}
