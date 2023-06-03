package org.raspberry.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.raspberry.auth.dao.repositories.UserAuthorityDao;
import org.raspberry.auth.exception.ServiceException;
import org.raspberry.auth.model.entities.UserAuthority;
import org.raspberry.auth.pojos.entities.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorityService {

	@Autowired
	private UserAuthorityDao userAuthorityDao;
	
	public List<UserAuthorityVO> findAllByUser(UserDetailsVO userDetailsVO) {
		List<UserAuthorityVO> userAuthorityListVO = new ArrayList<>();

		for (UserAuthority userAuthority : userAuthorityDao.findAllByUser(userDetailsVO.getIdUser())) {
			UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
			userAuthorityVO.setIdAuthority(userAuthority.getIdAuthority());
			userAuthorityVO.setIdUser(userAuthority.getIdUser());
			userAuthorityVO.setName(userAuthority.getName());

			userAuthorityListVO.add(userAuthorityVO);
		}
		
		return userAuthorityListVO;
	}
	
	public UserAuthorityVO createOne(UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = new UserAuthority();
		userAuthority.setIdUser(userAuthorityVO.getIdUser());
		userAuthority.setName(userAuthorityVO.getName());
		userAuthority = userAuthorityDao.save(userAuthority);

		userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(userAuthority.getIdAuthority());
		userAuthorityVO.setIdUser(userAuthority.getIdUser());
		userAuthorityVO.setName(userAuthority.getName());

		return userAuthorityVO;
	}
	
	public UserAuthorityVO updateOne(UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = userAuthorityDao.findOneById(userAuthorityVO.getIdAuthority());
		if (userAuthority == null) {
			throw new ServiceException("UserAuthority [IdAuthority: " + userAuthorityVO.getIdAuthority() + "] not exists");
		}
		
		userAuthority.setIdUser(userAuthorityVO.getIdUser());
		userAuthority.setName(userAuthorityVO.getName());
		userAuthority = userAuthorityDao.save(userAuthority);

		userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(userAuthority.getIdAuthority());
		userAuthorityVO.setIdUser(userAuthority.getIdUser());
		userAuthorityVO.setName(userAuthority.getName());

		return userAuthorityVO;
	}
	
	public void deleteOne(UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = userAuthorityDao.findOneById(userAuthorityVO.getIdAuthority());
		if (userAuthority == null) {
			throw new ServiceException("UserAuthority [IdAuthority: " + userAuthorityVO.getIdAuthority() + "] not exists");
		}

		userAuthorityDao.delete(userAuthority);
	}

}
