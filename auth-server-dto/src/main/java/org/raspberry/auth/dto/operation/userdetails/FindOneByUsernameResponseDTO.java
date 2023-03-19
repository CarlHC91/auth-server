package org.raspberry.auth.dto.operation.userdetails;

import org.raspberry.auth.dto.model.users.UserDetailsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByUsernameResponseDTO {

	@JsonProperty("status")
	private String status;

	@JsonProperty("status_message")
	private String statusMessage;

	@JsonProperty("data")
	private UserDetailsDTO data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public UserDetailsDTO getData() {
		return data;
	}

	public void setData(UserDetailsDTO data) {
		this.data = data;
	}

}
