package org.raspberry.auth.pojos.operations.userdetails;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOne_IN {

	@JsonProperty("user_details")
	private UserDetailsVO userDetails;

	public UserDetailsVO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsVO userDetails) {
		this.userDetails = userDetails;
	}

}
