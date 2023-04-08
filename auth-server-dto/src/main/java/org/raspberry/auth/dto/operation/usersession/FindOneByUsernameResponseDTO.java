package org.raspberry.auth.dto.operation.usersession;

import org.raspberry.auth.dto.model.users.UserSessionDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindOneByUsernameResponseDTO {

	@JsonProperty("user_session")
	private UserSessionDTO userSession;

	public UserSessionDTO getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSessionDTO userSession) {
		this.userSession = userSession;
	}

}
