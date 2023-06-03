package org.raspberry.auth.pojos.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestHeaderVO {

	@JsonProperty("token_api")
	private String tokenApi;

	public String getTokenApi() {
		return tokenApi;
	}

	public void setTokenApi(String tokenApi) {
		this.tokenApi = tokenApi;
	}

}