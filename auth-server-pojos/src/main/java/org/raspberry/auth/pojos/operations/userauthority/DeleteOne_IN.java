package org.raspberry.auth.pojos.operations.userauthority;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteOne_IN {

	@JsonProperty("user_authority")
	private UserAuthorityVO userAuthority;

	public UserAuthorityVO getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthorityVO userAuthority) {
		this.userAuthority = userAuthority;
	}

}
