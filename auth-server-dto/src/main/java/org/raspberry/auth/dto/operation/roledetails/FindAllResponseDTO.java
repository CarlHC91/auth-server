package org.raspberry.auth.dto.operation.roledetails;

import java.util.List;

import org.raspberry.auth.dto.model.roles.RoleDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllResponseDTO {

	@JsonProperty("role_details_list")
	private List<RoleDetailsDTO> roleDetailsList;

	public List<RoleDetailsDTO> getRoleDetailsList() {
		return roleDetailsList;
	}

	public void setRoleDetailsList(List<RoleDetailsDTO> roleDetailsList) {
		this.roleDetailsList = roleDetailsList;
	}

}
