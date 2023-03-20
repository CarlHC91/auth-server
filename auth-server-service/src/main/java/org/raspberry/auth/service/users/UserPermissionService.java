package org.raspberry.auth.service.users;

import org.raspberry.auth.dto.model.users.UserPermissionDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByFilterRequestDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByFilterResponseDTO;
import org.raspberry.auth.model.permissions.PermissionDetails;
import org.raspberry.auth.model.users.UserDetails;
import org.raspberry.auth.model.users.UserPermission;
import org.raspberry.auth.repository.permissions.PermissionDetailsDao;
import org.raspberry.auth.repository.users.UserDetailsDao;
import org.raspberry.auth.repository.users.UserPermissionDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {

	@Autowired
	private PermissionDetailsDao permissionDetailsDao;
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	@Autowired
	private UserPermissionDao userPermissionDao;
	
	public FindOneByFilterResponseDTO findOneByFilter(FindOneByFilterRequestDTO findOneByFilterRequestDTO) {
		UserPermissionDTO userPermissionDTO = null;
		
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(findOneByFilterRequestDTO.getTokenApi());
		if (userDetails == null) {
			throw new ServiceErrorException("UserDetails not exists");
		}
		
		PermissionDetails permissionDetails = permissionDetailsDao.findOneByServicePath(findOneByFilterRequestDTO.getServicePath());
		if (permissionDetails == null) {
			throw new ServiceErrorException("PermissionDetails not exists");
		}

		UserPermission userPermission = userPermissionDao.findOneById(userDetails.getIdUser(), permissionDetails.getIdPermission());
		if (userPermission != null) {
			userPermissionDTO = new UserPermissionDTO();
			userPermissionDTO.setIdPermission(userPermission.getIdPermission());
			userPermissionDTO.setIdUser(userPermission.getIdUser());
			userPermissionDTO.setCreateDate(userPermission.getCreateDate());
			userPermissionDTO.setUpdateDate(userPermission.getUpdateDate());
		}

		FindOneByFilterResponseDTO findOneByServicePathResponseDTO = new FindOneByFilterResponseDTO();
		findOneByServicePathResponseDTO.setStatus("ok");
		findOneByServicePathResponseDTO.setStatusMessage("Query was successful");
		findOneByServicePathResponseDTO.setData(userPermissionDTO);

		return findOneByServicePathResponseDTO;
	}

}