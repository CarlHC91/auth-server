package org.raspberry.auth.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.raspberry.auth.dao.user.UserDetailsDao;
import org.raspberry.auth.exception.ServiceException;
import org.raspberry.auth.model.user.UserDetails;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsVO findOneById(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
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
	
	public UserDetailsVO[] findAll(UserDetailsVO userSessionVO) {
		List<UserDetailsVO> userDetailsListVO = new ArrayList<>();
		
		
		for (UserDetails userDetails : userDetailsDao.findAll()) {
			UserDetailsVO userDetailsVO = new UserDetailsVO();
			userDetailsVO.setIdUser(userDetails.getIdUser());
			userDetailsVO.setUsername(userDetails.getUsername());
			userDetailsVO.setPassword(userDetails.getPassword());
			userDetailsVO.setTokenApi(userDetails.getTokenApi());
			userDetailsVO.setFirstName(userDetails.getFirstName());
			userDetailsVO.setLastName(userDetails.getLastName());
			
			userDetailsListVO.add(userDetailsVO);
		}

		return userDetailsListVO.toArray(new UserDetailsVO[userDetailsListVO.size()]);
	}
	
	public UserDetailsVO createOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(userDetailsVO.getUsername());
		userDetails.setPassword(userDetailsVO.getPassword());
		userDetails.setTokenApi(UUID.randomUUID().toString());
		userDetails.setFirstName(userDetailsVO.getFirstName());
		userDetails.setLastName(userDetailsVO.getLastName());
		userDetails = userDetailsDao.save(userDetails);

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setTokenApi(userDetails.getTokenApi());
		userDetailsVO.setFirstName(userDetails.getFirstName());
		userDetailsVO.setLastName(userDetails.getLastName());
		
		return userDetailsVO;
	}
	
	public UserDetailsVO updateOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("User '" + userDetailsVO.getIdUser() + "' not exists");
		}
		
		userDetails.setUsername(userDetailsVO.getUsername());
		userDetails.setPassword(userDetailsVO.getPassword());
		userDetails.setTokenApi(userDetailsVO.getTokenApi());
		userDetails.setFirstName(userDetailsVO.getFirstName());
		userDetails.setLastName(userDetailsVO.getLastName());
		userDetails = userDetailsDao.save(userDetails);

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setTokenApi(userDetails.getTokenApi());
		userDetailsVO.setFirstName(userDetails.getFirstName());
		userDetailsVO.setLastName(userDetails.getLastName());
		
		return userDetailsVO;
	}
	
	public void deleteOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("User '" + userDetailsVO.getIdUser() + "' not exists");
		}
		
		userDetailsDao.delete(userDetails);
	}
	
}
