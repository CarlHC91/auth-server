package org.raspberry.auth.dto.operation.userpermission;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByServicePathRequestDTO {

	@JsonProperty("token_api")
	private String tokenApi;

	@JsonProperty("service_path")
	private String servicePath;

	public String getTokenApi() {
		return tokenApi;
	}

	public void setTokenApi(String tokenApi) {
		this.tokenApi = tokenApi;
	}

	public String getServicePath() {
		return servicePath;
	}

	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}

}
