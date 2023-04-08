package org.raspberry.auth.dto.operation.userrole;

import java.util.List;

import org.raspberry.auth.dto.model.users.UserRoleDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllResponseDTO {

	@JsonProperty("user_role_list")
	private List<UserRoleDTO> userRoleList;

	public List<UserRoleDTO> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoleDTO> userRoleList) {
		this.userRoleList = userRoleList;
	}

}
