package org.raspberry.auth.dto.operation.rolepermission;

import org.raspberry.auth.dto.model.roles.RolePermissionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByIdResponseDTO {

	@JsonProperty("role_permission")
	private RolePermissionDTO rolePermission;

	public RolePermissionDTO getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(RolePermissionDTO rolePermission) {
		this.rolePermission = rolePermission;
	}

}
