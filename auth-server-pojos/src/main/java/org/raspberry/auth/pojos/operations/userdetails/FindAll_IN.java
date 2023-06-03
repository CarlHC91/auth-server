package org.raspberry.auth.pojos.operations.userdetails;

import org.raspberry.auth.pojos.entities.RequestHeaderVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAll_IN {

	@JsonProperty("request_header")
	private RequestHeaderVO requestHeader;

	public RequestHeaderVO getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeaderVO requestHeader) {
		this.requestHeader = requestHeader;
	}

}
