package org.raspberry.auth.dto.operation.usersession;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HasPermissionResponseDTO {

	@JsonProperty("result")
	private Boolean result;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

}
