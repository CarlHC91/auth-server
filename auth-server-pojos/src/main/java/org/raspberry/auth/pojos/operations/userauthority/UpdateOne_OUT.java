package org.raspberry.auth.pojos.operations.userauthority;

import org.raspberry.auth.pojos.entities.UserAuthorityVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateOne_OUT {

	@JsonProperty("user_authority")
	private UserAuthorityVO userAuthority;

	public UserAuthorityVO getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthorityVO userAuthority) {
		this.userAuthority = userAuthority;
	}

}
