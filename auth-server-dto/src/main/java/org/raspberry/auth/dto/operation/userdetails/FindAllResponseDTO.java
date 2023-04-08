package org.raspberry.auth.dto.operation.userdetails;

import java.util.List;

import org.raspberry.auth.dto.model.users.UserDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllResponseDTO {

	@JsonProperty("user_details_list")
	private List<UserDetailsDTO> userDetailsList;

	public List<UserDetailsDTO> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetailsDTO> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

}
