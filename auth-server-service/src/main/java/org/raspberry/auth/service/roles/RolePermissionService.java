package org.raspberry.auth.service.roles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.roles.RolePermissionDTO;
import org.raspberry.auth.model.roles.RolePermission;
import org.raspberry.auth.repository.roles.RolePermissionDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionService {

	@Autowired
	private RolePermissionDao rolePermissionDao;

	public RolePermissionDTO findOneById(HeaderRequestDTO headerRequestDTO, RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermission = rolePermissionDao.findOneById(rolePermissionDTO.getIdPermission());
		if (rolePermission == null) {
			return null;
		}
		
		rolePermissionDTO = new RolePermissionDTO();
		rolePermissionDTO.setIdPermission(rolePermission.getIdPermission());
		rolePermissionDTO.setIdRole(rolePermission.getIdRole());
		rolePermissionDTO.setServicePath(rolePermission.getServicePath());
		rolePermissionDTO.setCreateDate(rolePermission.getCreateDate());
		rolePermissionDTO.setUpdateDate(rolePermission.getUpdateDate());

		return rolePermissionDTO;
	}

	public RolePermissionDTO findOneByServicePath(HeaderRequestDTO headerRequestDTO, RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermission = rolePermissionDao.findOneByServicePath(rolePermissionDTO.getServicePath());
		if (rolePermission == null) {
			return null;
		}
		
		rolePermissionDTO = new RolePermissionDTO();
		rolePermissionDTO.setIdPermission(rolePermission.getIdPermission());
		rolePermissionDTO.setIdRole(rolePermission.getIdRole());
		rolePermissionDTO.setServicePath(rolePermission.getServicePath());
		rolePermissionDTO.setCreateDate(rolePermission.getCreateDate());
		rolePermissionDTO.setUpdateDate(rolePermission.getUpdateDate());

		return rolePermissionDTO;
	}
	
	public List<RolePermissionDTO> findAll(HeaderRequestDTO headerRequestDTO) {
		List<RolePermissionDTO> rolePermissionListDTO = new ArrayList<>();

		for (RolePermission rolePermission : rolePermissionDao.findAll()) {
			RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
			rolePermissionDTO.setIdPermission(rolePermission.getIdPermission());
			rolePermissionDTO.setIdRole(rolePermission.getIdRole());
			rolePermissionDTO.setServicePath(rolePermission.getServicePath());
			rolePermissionDTO.setCreateDate(rolePermission.getCreateDate());
			rolePermissionDTO.setUpdateDate(rolePermission.getUpdateDate());

			rolePermissionListDTO.add(rolePermissionDTO);
		}
		
		return rolePermissionListDTO;
	}
	
	public RolePermissionDTO createOne(HeaderRequestDTO headerRequestDTO, RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermission = new RolePermission();
		rolePermission.setIdRole(rolePermissionDTO.getIdRole());
		rolePermission.setServicePath(rolePermissionDTO.getServicePath());
		rolePermission.setCreateDate(new Date());
		rolePermission = rolePermissionDao.save(rolePermission);

		rolePermissionDTO = new RolePermissionDTO();
		rolePermissionDTO.setIdPermission(rolePermission.getIdPermission());
		rolePermissionDTO.setIdRole(rolePermission.getIdRole());
		rolePermissionDTO.setServicePath(rolePermission.getServicePath());
		rolePermissionDTO.setCreateDate(rolePermission.getCreateDate());
		rolePermissionDTO.setUpdateDate(rolePermission.getUpdateDate());

		return rolePermissionDTO;
	}
	
	public RolePermissionDTO updateOne(HeaderRequestDTO headerRequestDTO, RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermission = rolePermissionDao.findOneById(rolePermissionDTO.getIdPermission());
		if (rolePermission == null) {
			throw new ServiceErrorException("RolePermission [IdPermission: " + rolePermissionDTO.getIdPermission() + "] not exists");
		}
		
		rolePermission.setIdRole(rolePermissionDTO.getIdRole());
		rolePermission.setServicePath(rolePermissionDTO.getServicePath());
		rolePermission.setUpdateDate(new Date());
		rolePermission = rolePermissionDao.save(rolePermission);

		rolePermissionDTO = new RolePermissionDTO();
		rolePermissionDTO.setIdPermission(rolePermission.getIdPermission());
		rolePermissionDTO.setIdRole(rolePermission.getIdRole());
		rolePermissionDTO.setServicePath(rolePermission.getServicePath());
		rolePermissionDTO.setCreateDate(rolePermission.getCreateDate());
		rolePermissionDTO.setUpdateDate(rolePermission.getUpdateDate());

		return rolePermissionDTO;
	}
	
	public void deleteOne(HeaderRequestDTO headerRequestDTO, RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermission = rolePermissionDao.findOneById(rolePermissionDTO.getIdPermission());
		if (rolePermission == null) {
			throw new ServiceErrorException("RolePermission [IdPermission: " + rolePermissionDTO.getIdPermission() + "] not exists");
		}

		rolePermissionDao.delete(rolePermission);
	}

}
