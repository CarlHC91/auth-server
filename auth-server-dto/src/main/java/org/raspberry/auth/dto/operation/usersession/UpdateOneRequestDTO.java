package org.raspberry.auth.dto.operation.usersession;

import org.raspberry.auth.dto.common.HeaderRequestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOneRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

}
