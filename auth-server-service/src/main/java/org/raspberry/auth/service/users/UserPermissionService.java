package org.raspberry.auth.service.users;

import org.raspberry.auth.dto.model.users.UserPermissionDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathRequestDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathResponseDTO;
import org.raspberry.auth.model.users.UserDetails;
import org.raspberry.auth.model.users.UserPermission;
import org.raspberry.auth.repository.users.UserDetailsDao;
import org.raspberry.auth.repository.users.UserPermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	@Autowired
	private UserPermissionDao userPermissionDao;
	
	public FindOneByServicePathResponseDTO findOneByServicePath(FindOneByServicePathRequestDTO findOneByServicePathRequestDTO) {
		UserPermissionDTO userPermissionDTO = null;
		
		UserDetails userDetails = userDetailsDao.findOneByTokenApi(findOneByServicePathRequestDTO.getTokenApi());
		if (userDetails == null) {
			FindOneByServicePathResponseDTO findOneByServicePathResponseDTO = new FindOneByServicePathResponseDTO();
			findOneByServicePathResponseDTO.setStatus("ok");
			findOneByServicePathResponseDTO.setStatusMessage("Query was successful");
			findOneByServicePathResponseDTO.setData(userPermissionDTO);

			return findOneByServicePathResponseDTO;
		}

		UserPermission userPermission = userPermissionDao.findOneByServicePath(userDetails.getIdUser(), findOneByServicePathRequestDTO.getServicePath());
		if (userPermission != null) {
			userPermissionDTO = new UserPermissionDTO();
			userPermissionDTO.setIdPermission(userPermission.getIdPermission());
			userPermissionDTO.setIdUser(userPermission.getIdUser());
			userPermissionDTO.setServicePath(userPermission.getServicePath());
			userPermissionDTO.setCreateDate(userPermission.getCreateDate());
			userPermissionDTO.setUpdateDate(userPermission.getUpdateDate());
		}

		FindOneByServicePathResponseDTO findOneByServicePathResponseDTO = new FindOneByServicePathResponseDTO();
		findOneByServicePathResponseDTO.setStatus("ok");
		findOneByServicePathResponseDTO.setStatusMessage("Query was successful");
		findOneByServicePathResponseDTO.setData(userPermissionDTO);

		return findOneByServicePathResponseDTO;
	}

}