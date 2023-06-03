package org.raspberry.auth.pojos.operations.userdetails;

import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOne_IN {

	@JsonProperty("request_header")
	private RequestHeaderVO requestHeader;

	@JsonProperty("user_details")
	private UserDetailsVO userDetails;

	public RequestHeaderVO getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeaderVO requestHeader) {
		this.requestHeader = requestHeader;
	}

	public UserDetailsVO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsVO userDetails) {
		this.userDetails = userDetails;
	}

}
