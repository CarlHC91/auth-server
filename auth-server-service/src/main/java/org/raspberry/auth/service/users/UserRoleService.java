package org.raspberry.auth.service.users;

import java.util.Date;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.users.UserRoleDTO;
import org.raspberry.auth.model.users.UserRole;
import org.raspberry.auth.repository.users.UserRoleDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	public UserRoleDTO findOneById(HeaderRequestDTO headerRequestDTO, UserRoleDTO userRoleDTO) {
		UserRole userRole = userRoleDao.findOneById(userRoleDTO.getIdUser(), userRoleDTO.getIdRole());
		if (userRole == null) {
			return null;
		}
		
		userRoleDTO = new UserRoleDTO();
		userRoleDTO.setIdUser(userRole.getIdUser());
		userRoleDTO.setIdRole(userRole.getIdRole());
		userRoleDTO.setCreateDate(userRole.getCreateDate());
		userRoleDTO.setUpdateDate(userRole.getUpdateDate());

		return userRoleDTO;
	}
	
	public UserRoleDTO createOne(HeaderRequestDTO headerRequestDTO, UserRoleDTO userRoleDTO) {
		UserRole userRole = new UserRole();
		userRole.setIdUser(userRoleDTO.getIdUser());
		userRole.setIdRole(userRoleDTO.getIdRole());
		userRole.setCreateDate(new Date());
		userRole = userRoleDao.save(userRole);

		userRoleDTO = new UserRoleDTO();
		userRoleDTO.setIdUser(userRole.getIdUser());
		userRoleDTO.setIdRole(userRole.getIdRole());
		userRoleDTO.setCreateDate(userRole.getCreateDate());
		userRoleDTO.setUpdateDate(userRole.getUpdateDate());
		
		return userRoleDTO;
	}
	
	public void deleteOne(HeaderRequestDTO headerRequestDTO, UserRoleDTO userRoleDTO) {
		UserRole userRole = userRoleDao.findOneById(userRoleDTO.getIdUser(), userRoleDTO.getIdRole());
		if (userRole == null) {
			throw new ServiceErrorException("UserRole [IdUser: " + userRoleDTO.getIdUser() + ", IdRole: " + userRoleDTO.getIdRole() + "] not exists");
		}
		
		userRoleDao.delete(userRole);
	}

}