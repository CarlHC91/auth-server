package org.raspberry.auth.service.users;

import java.util.Date;

import org.raspberry.auth.dto.model.roles.RolePermissionDTO;
import org.raspberry.auth.dto.model.users.UserSessionDTO;
import org.raspberry.auth.model.roles.RolePermission;
import org.raspberry.auth.model.users.UserDetails;
import org.raspberry.auth.model.users.UserRole;
import org.raspberry.auth.repository.roles.RolePermissionDao;
import org.raspberry.auth.repository.users.UserDetailsDao;
import org.raspberry.auth.repository.users.UserRoleDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {

	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Autowired
	private UserDetailsDao userDetailsDao;
	@Autowired
	private UserRoleDao userRoleDao;

	public UserSessionDTO findOneByTokenApi(UserSessionDTO userSessionDTO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(userSessionDTO.getTokenApi());
		if (userDetails == null) {
			return null;
		}
		
		userSessionDTO = new UserSessionDTO();
		userSessionDTO.setIdUser(userDetails.getIdUser());
		userSessionDTO.setUsername(userDetails.getUsername());
		userSessionDTO.setPassword(userDetails.getPassword());
		userSessionDTO.setTokenApi(userDetails.getTokenApi());
		userSessionDTO.setFirstName(userDetails.getFirstName());
		userSessionDTO.setLastName(userDetails.getLastName());
		userSessionDTO.setCreateDate(userDetails.getCreateDate());
		userSessionDTO.setUpdateDate(userDetails.getUpdateDate());

		return userSessionDTO;
	}
	
	public UserSessionDTO findOneByUsername(UserSessionDTO userSessionDTO) {
		UserDetails userDetails = userDetailsDao.findOneByUsername(userSessionDTO.getUsername(), userSessionDTO.getPassword());
		if (userDetails == null) {
			return null;
		}
		
		userSessionDTO = new UserSessionDTO();
		userSessionDTO.setIdUser(userDetails.getIdUser());
		userSessionDTO.setUsername(userDetails.getUsername());
		userSessionDTO.setPassword(userDetails.getPassword());
		userSessionDTO.setTokenApi(userDetails.getTokenApi());
		userSessionDTO.setFirstName(userDetails.getFirstName());
		userSessionDTO.setLastName(userDetails.getLastName());
		userSessionDTO.setCreateDate(userDetails.getCreateDate());
		userSessionDTO.setUpdateDate(userDetails.getUpdateDate());

		return userSessionDTO;
	}
	
	public Boolean hasPermission(UserSessionDTO userSessionDTO, RolePermissionDTO rolePermissionDTO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(userSessionDTO.getTokenApi());
		if (userDetails == null) {
			throw new ServiceErrorException("UserSession [TokenApi: " + userSessionDTO.getTokenApi() + "] not exists");
		}
		
		RolePermission rolePermission = rolePermissionDao.findOneByServicePath(rolePermissionDTO.getServicePath());
		if (rolePermission == null) {
			throw new ServiceErrorException("RolePermission [ServicePath: " + rolePermissionDTO.getServicePath() + "] not exists");
		}
		
		UserRole userRole = userRoleDao.findOneById(userDetails.getIdUser(), rolePermission.getIdRole());
		if (userRole == null) {
			return false;
		}

		return true;
	}
	
	public UserSessionDTO updateOne(UserSessionDTO userSessionDTO) {
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(userSessionDTO.getTokenApi());
		if (userDetails == null) {
			throw new ServiceErrorException("UserSession [TokenApi: " + userSessionDTO.getTokenApi() + "] not exists");
		}
		
		userDetails.setPassword(userSessionDTO.getPassword());
		userDetails.setFirstName(userSessionDTO.getFirstName());
		userDetails.setLastName(userSessionDTO.getLastName());
		userDetails.setUpdateDate(new Date());
		userDetails = userDetailsDao.save(userDetails);

		userSessionDTO = new UserSessionDTO();
		userSessionDTO.setIdUser(userDetails.getIdUser());
		userSessionDTO.setUsername(userDetails.getUsername());
		userSessionDTO.setPassword(userDetails.getPassword());
		userSessionDTO.setTokenApi(userDetails.getTokenApi());
		userSessionDTO.setFirstName(userDetails.getFirstName());
		userSessionDTO.setLastName(userDetails.getLastName());
		userSessionDTO.setCreateDate(userDetails.getCreateDate());
		userSessionDTO.setUpdateDate(userDetails.getUpdateDate());

		return userSessionDTO;
	}
	
	public void deleteOne(UserSessionDTO userSessionDTO) {
		UserDetails userDetails = userDetailsDao.findOneById(userSessionDTO.getIdUser());
		if (userDetails == null) {
			throw new ServiceErrorException("UserSession [TokenApi: " + userSessionDTO.getTokenApi() + "] not exists");
		}

		userDetailsDao.delete(userDetails);
	}
	
}
