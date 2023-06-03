package org.raspberry.auth.service;

import org.raspberry.auth.dao.repositories.UserDetailsDao;
import org.raspberry.auth.model.entities.UserDetails;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsVO findOneByTokenApi(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(userDetailsVO.getTokenApi());
		if (userDetails == null) {
			return null;
		}

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setTokenApi(userDetails.getTokenApi());
		userDetailsVO.setFirstName(userDetails.getFirstName());
		userDetailsVO.setLastName(userDetails.getLastName());

		return userDetailsVO;
	}

}
