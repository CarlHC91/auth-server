package org.raspberry.auth.service.users;

import org.raspberry.auth.dto.model.users.UserDetailsDTO;
import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameRequestDTO;
import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameResponseDTO;
import org.raspberry.auth.model.users.UserDetails;
import org.raspberry.auth.repository.users.UserDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	public FindOneByUsernameResponseDTO findOneByUsername(FindOneByUsernameRequestDTO findOneByUsernameRequestDTO) {
		UserDetailsDTO userDetailsDTO = null;

		UserDetails userDetails = userDetailsDao.findOneByUsername(findOneByUsernameRequestDTO.getUsername(), findOneByUsernameRequestDTO.getPassword());
		if (userDetails != null) {
			userDetailsDTO = new UserDetailsDTO();
			userDetailsDTO.setIdUser(userDetails.getIdUser());
			userDetailsDTO.setUsername(userDetails.getUsername());
			userDetailsDTO.setPassword(userDetails.getPassword());
			userDetailsDTO.setTokenApi(userDetails.getTokenApi());
			userDetailsDTO.setFirstName(userDetails.getFirstName());
			userDetailsDTO.setLastName(userDetails.getLastName());
			userDetailsDTO.setCreateDate(userDetails.getCreateDate());
			userDetailsDTO.setUpdateDate(userDetails.getUpdateDate());
		}

		FindOneByUsernameResponseDTO findOneByUsernameResponseDTO = new FindOneByUsernameResponseDTO();
		findOneByUsernameResponseDTO.setStatus("ok");
		findOneByUsernameResponseDTO.setStatusMessage("Query was successful");
		findOneByUsernameResponseDTO.setData(userDetailsDTO);

		return findOneByUsernameResponseDTO;
	}

}