package org.raspberry.auth.service.user;

import java.util.ArrayList;
import java.util.List;

import org.raspberry.auth.dao.user.UserAuthorityDao;
import org.raspberry.auth.exception.ServiceException;
import org.raspberry.auth.model.user.UserAuthority;
import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorityService {

	@Autowired
	private UserAuthorityDao userAuthorityDao;

	public UserAuthorityVO findOneById(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = userAuthorityDao.findOneById(userAuthorityVO.getIdAuthority());
		if (userAuthority == null) {
			return null;
		}

		userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(userAuthority.getIdAuthority());
		userAuthorityVO.setIdUser(userAuthority.getIdUser());
		userAuthorityVO.setName(userAuthority.getName());

		return userAuthorityVO;
	}

	public UserAuthorityVO[] findAllByUser(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		List<UserAuthorityVO> userAuthorityListVO = new ArrayList<>();

		for (UserAuthority userAuthority : userAuthorityDao.findAllByUser(userDetailsVO.getIdUser())) {
			UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
			userAuthorityVO.setIdAuthority(userAuthority.getIdAuthority());
			userAuthorityVO.setIdUser(userAuthority.getIdUser());
			userAuthorityVO.setName(userAuthority.getName());

			userAuthorityListVO.add(userAuthorityVO);
		}

		return userAuthorityListVO.toArray(new UserAuthorityVO[userAuthorityListVO.size()]);
	}

	public UserAuthorityVO createOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
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

	public UserAuthorityVO updateOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = userAuthorityDao.findOneById(userAuthorityVO.getIdAuthority());
		if (userAuthority == null) {
			throw new ServiceException("Authority '" + userAuthorityVO.getIdAuthority() + "' not exists");
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

	public void deleteOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		UserAuthority userAuthority = userAuthorityDao.findOneById(userAuthorityVO.getIdAuthority());
		if (userAuthority == null) {
			throw new ServiceException("Authority '" + userAuthorityVO.getIdAuthority() + "' not exists");
		}

		userAuthorityDao.delete(userAuthority);
	}

}
