package org.raspberry.auth.service.users;

import java.util.Date;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.users.UserDetailsDTO;
import org.raspberry.auth.model.users.UserDetails;
import org.raspberry.auth.repository.users.UserDetailsDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsDTO findOneById(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsDTO.getIdUser());
		if (userDetails == null) {
			return null;
		}
		
		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setIdUser(userDetails.getIdUser());
		userDetailsDTO.setUsername(userDetails.getUsername());
		userDetailsDTO.setPassword(userDetails.getPassword());
		userDetailsDTO.setTokenApi(userDetails.getTokenApi());
		userDetailsDTO.setFirstName(userDetails.getFirstName());
		userDetailsDTO.setLastName(userDetails.getLastName());
		userDetailsDTO.setCreateDate(userDetails.getCreateDate());
		userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsDTO;
	}

	public UserDetailsDTO findOneByTokenApi(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(userDetailsDTO.getTokenApi());
		if (userDetails == null) {
			return null;
		}
		
		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setIdUser(userDetails.getIdUser());
		userDetailsDTO.setUsername(userDetails.getUsername());
		userDetailsDTO.setPassword(userDetails.getPassword());
		userDetailsDTO.setTokenApi(userDetails.getTokenApi());
		userDetailsDTO.setFirstName(userDetails.getFirstName());
		userDetailsDTO.setLastName(userDetails.getLastName());
		userDetailsDTO.setCreateDate(userDetails.getCreateDate());
		userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsDTO;
	}
	
	public UserDetailsDTO findOneByUsername(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = userDetailsDao.findOneByUsername(userDetailsDTO.getUsername(), userDetailsDTO.getPassword());
		if (userDetails == null) {
			return null;
		}
		
		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setIdUser(userDetails.getIdUser());
		userDetailsDTO.setUsername(userDetails.getUsername());
		userDetailsDTO.setPassword(userDetails.getPassword());
		userDetailsDTO.setTokenApi(userDetails.getTokenApi());
		userDetailsDTO.setFirstName(userDetails.getFirstName());
		userDetailsDTO.setLastName(userDetails.getLastName());
		userDetailsDTO.setCreateDate(userDetails.getCreateDate());
		userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsDTO;
	}

	public UserDetailsDTO createOne(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(userDetailsDTO.getUsername());
		userDetails.setPassword(userDetailsDTO.getPassword());
		userDetails.setTokenApi(userDetailsDTO.getTokenApi());
		userDetails.setFirstName(userDetailsDTO.getFirstName());
		userDetails.setLastName(userDetailsDTO.getLastName());
		userDetails.setCreateDate(new Date());
		userDetails = userDetailsDao.save(userDetails);

		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setIdUser(userDetails.getIdUser());
		userDetailsDTO.setUsername(userDetails.getUsername());
		userDetailsDTO.setPassword(userDetails.getPassword());
		userDetailsDTO.setTokenApi(userDetails.getTokenApi());
		userDetailsDTO.setFirstName(userDetails.getFirstName());
		userDetailsDTO.setLastName(userDetails.getLastName());
		userDetailsDTO.setCreateDate(userDetails.getCreateDate());
		userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());
		
		return userDetailsDTO;
	}
	
	public UserDetailsDTO updateOne(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsDTO.getIdUser());
		if (userDetails == null) {
			throw new ServiceErrorException("UserDetails [IdUser: " + userDetailsDTO.getIdUser() + "] not exists");
		}
		
		userDetails.setUsername(userDetailsDTO.getUsername());
		userDetails.setPassword(userDetailsDTO.getPassword());
		userDetails.setTokenApi(userDetailsDTO.getTokenApi());
		userDetails.setFirstName(userDetailsDTO.getFirstName());
		userDetails.setLastName(userDetailsDTO.getLastName());
		userDetails.setUpdateDate(new Date());
		userDetails = userDetailsDao.save(userDetails);

		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setIdUser(userDetails.getIdUser());
		userDetailsDTO.setUsername(userDetails.getUsername());
		userDetailsDTO.setPassword(userDetails.getPassword());
		userDetailsDTO.setTokenApi(userDetails.getTokenApi());
		userDetailsDTO.setFirstName(userDetails.getFirstName());
		userDetailsDTO.setLastName(userDetails.getLastName());
		userDetailsDTO.setCreateDate(userDetails.getCreateDate());
		userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsDTO;
	}
	
	public void deleteOne(HeaderRequestDTO headerRequestDTO, UserDetailsDTO userDetailsDTO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsDTO.getIdUser());
		if (userDetails == null) {
			throw new ServiceErrorException("UserDetails [IdUser: " + userDetailsDTO.getIdUser() + "] not exists");
		}

		userDetailsDao.delete(userDetails);
	}
	
}
