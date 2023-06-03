package org.raspberry.auth.pojos.operations.userauthority;

import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserAuthorityVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOne_IN {

	@JsonProperty("request_header")
	private RequestHeaderVO requestHeader;

	@JsonProperty("user_authority")
	private UserAuthorityVO userAuthority;

	public RequestHeaderVO getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeaderVO requestHeader) {
		this.requestHeader = requestHeader;
	}

	public UserAuthorityVO getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthorityVO userAuthority) {
		this.userAuthority = userAuthority;
	}

}
