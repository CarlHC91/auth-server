package org.raspberry.auth.dto.operation.userdetails;

import org.raspberry.auth.dto.model.users.UserDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByIdResponseDTO {

	@JsonProperty("user_details")
	private UserDetailsDTO userDetails;

	public UserDetailsDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsDTO userDetails) {
		this.userDetails = userDetails;
	}

}
