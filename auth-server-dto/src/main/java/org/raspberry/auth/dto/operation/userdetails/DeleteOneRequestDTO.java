package org.raspberry.auth.dto.operation.userdetails;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.users.UserDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteOneRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	@JsonProperty("user_details")
	private UserDetailsDTO userDetails;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

	public UserDetailsDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsDTO userDetails) {
		this.userDetails = userDetails;
	}

}
