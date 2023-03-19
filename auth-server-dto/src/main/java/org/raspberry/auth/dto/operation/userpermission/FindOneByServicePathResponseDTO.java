package org.raspberry.auth.dto.operation.userpermission;

import org.raspberry.auth.dto.model.users.UserPermissionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByServicePathResponseDTO {

	@JsonProperty("status")
	private String status;

	@JsonProperty("status_message")
	private String statusMessage;

	@JsonProperty("data")
	private UserPermissionDTO data;

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

	public UserPermissionDTO getData() {
		return data;
	}

	public void setData(UserPermissionDTO data) {
		this.data = data;
	}

}
