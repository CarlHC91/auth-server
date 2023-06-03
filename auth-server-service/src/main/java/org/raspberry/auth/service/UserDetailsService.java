package org.raspberry.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.raspberry.auth.dao.repositories.UserDetailsDao;
import org.raspberry.auth.exception.ServiceException;
import org.raspberry.auth.model.entities.UserDetails;
import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public List<UserDetailsVO> findAll(RequestHeaderVO requestHeaderVO) {
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

		return userDetailsListVO;
	}
	
	public UserDetailsVO createOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = new UserDetails();
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
	
	public UserDetailsVO updateOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("UserDetails [IdUser: " + userDetailsVO.getIdUser() + "] not exists");
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
	
	public void deleteOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("UserDetails [IdUser: " + userDetailsVO.getIdUser() + "] not exists");
		}
		
		userDetailsDao.delete(userDetails);
	}
	
}