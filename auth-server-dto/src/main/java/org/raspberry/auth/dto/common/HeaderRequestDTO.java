package org.raspberry.auth.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeaderRequestDTO {

	@JsonProperty("token_api")
	private String tokenApi;

	public String getTokenApi() {
		return tokenApi;
	}

	public void setTokenApi(String tokenApi) {
		this.tokenApi = tokenApi;
	}

}
