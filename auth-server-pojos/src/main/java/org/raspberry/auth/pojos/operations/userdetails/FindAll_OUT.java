package org.raspberry.auth.pojos.operations.userdetails;

import java.util.List;

import org.raspberry.auth.pojos.entities.UserDetailsVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAll_OUT {

	@JsonProperty("user_details_list")
	private List<UserDetailsVO> userDetailsList;

	public List<UserDetailsVO> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetailsVO> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

}
