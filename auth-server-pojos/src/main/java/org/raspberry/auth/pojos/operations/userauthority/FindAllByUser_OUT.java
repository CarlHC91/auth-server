package org.raspberry.auth.pojos.operations.userauthority;

import java.util.List;

import org.raspberry.auth.pojos.entities.UserAuthorityVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindAllByUser_OUT {

	@JsonProperty("user_authority_list")
	private List<UserAuthorityVO> userAuthorityList;

	public List<UserAuthorityVO> getUserAuthorityList() {
		return userAuthorityList;
	}

	public void setUserAuthorityList(List<UserAuthorityVO> userAuthorityList) {
		this.userAuthorityList = userAuthorityList;
	}

}
