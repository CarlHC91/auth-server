package org.raspberry.auth.service;

import org.raspberry.auth.dao.repositories.UserDetailsDao;
import org.raspberry.auth.model.entities.UserDetails;
import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsVO findOneByTokenApi(RequestHeaderVO requestHeaderVO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(requestHeaderVO.getTokenApi());
		if (userDetails == null) {
			return null;
		}

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setTokenApi(userDetails.getTokenApi());
		userDetailsVO.setFirstName(userDetails.getFirstName());
		userDetailsVO.setLastName(userDetails.getLastName());

		return userDetailsVO;
	}

}
