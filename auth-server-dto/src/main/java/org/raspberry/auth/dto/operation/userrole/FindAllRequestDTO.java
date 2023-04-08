package org.raspberry.auth.dto.operation.userrole;

import org.raspberry.auth.dto.common.HeaderRequestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllRequestDTO {

	@JsonProperty("header_request")
	private HeaderRequestDTO headerRequest;

	public HeaderRequestDTO getHeaderRequest() {
		return headerRequest;
	}

	public void setHeaderRequest(HeaderRequestDTO headerRequest) {
		this.headerRequest = headerRequest;
	}

}
