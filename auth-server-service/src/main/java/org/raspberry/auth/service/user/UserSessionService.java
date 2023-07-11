package org.raspberry.auth.service.user;

import org.raspberry.auth.dao.user.UserDetailsDao;
import org.raspberry.auth.model.user.UserDetails;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsVO findOneByTokenApi(UserDetailsVO userSessionVO) {
		UserDetails userSession = userDetailsDao.findOneByTokenApi(userSessionVO.getTokenApi());
		if (userSession == null) {
			return null;
		}

		userSessionVO = new UserDetailsVO();
		userSessionVO.setIdUser(userSession.getIdUser());
		userSessionVO.setUsername(userSession.getUsername());
		userSessionVO.setPassword(userSession.getPassword());
		userSessionVO.setTokenApi(userSession.getTokenApi());
		userSessionVO.setFirstName(userSession.getFirstName());
		userSessionVO.setLastName(userSession.getLastName());

		return userSessionVO;
	}
	
	public UserDetailsVO findOneByUsername(UserDetailsVO userSessionVO) {
		UserDetails userSession = userDetailsDao.findOneByUsername(userSessionVO.getUsername(), userSessionVO.getPassword());
		if (userSession == null) {
			return null;
		}

		userSessionVO = new UserDetailsVO();
		userSessionVO.setIdUser(userSession.getIdUser());
		userSessionVO.setUsername(userSession.getUsername());
		userSessionVO.setPassword(userSession.getPassword());
		userSessionVO.setTokenApi(userSession.getTokenApi());
		userSessionVO.setFirstName(userSession.getFirstName());
		userSessionVO.setLastName(userSession.getLastName());

		return userSessionVO;
	}

}
