package org.raspberry.auth.dto.operation.rolepermission;

import java.util.List;

import org.raspberry.auth.dto.model.roles.RolePermissionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllResponseDTO {

	@JsonProperty("role_permission_list")
	private List<RolePermissionDTO> rolePermissionList;

	public List<RolePermissionDTO> getRolePermissionList() {
		return rolePermissionList;
	}

	public void setRolePermissionList(List<RolePermissionDTO> rolePermissionList) {
		this.rolePermissionList = rolePermissionList;
	}

}
