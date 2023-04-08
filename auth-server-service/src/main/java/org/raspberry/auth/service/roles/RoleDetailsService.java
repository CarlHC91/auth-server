package org.raspberry.auth.service.roles;

import java.util.Date;

import org.raspberry.auth.dto.common.HeaderRequestDTO;
import org.raspberry.auth.dto.model.roles.RoleDetailsDTO;
import org.raspberry.auth.model.roles.RoleDetails;
import org.raspberry.auth.repository.roles.RoleDetailsDao;
import org.raspberry.auth.service.exceptions.ServiceErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDetailsService {

	@Autowired
	private RoleDetailsDao roleDetailsDao;

	public RoleDetailsDTO findOneById(HeaderRequestDTO headerRequestDTO, RoleDetailsDTO roleDetailsDTO) {
		RoleDetails roleDetails = roleDetailsDao.findOneById(roleDetailsDTO.getIdRole());
		if (roleDetails == null) {
			return null;
		}

		roleDetailsDTO = new RoleDetailsDTO();
		roleDetailsDTO.setIdRole(roleDetails.getIdRole());
		roleDetailsDTO.setName(roleDetails.getName());
		roleDetailsDTO.setCreateDate(roleDetails.getCreateDate());
		roleDetailsDTO.setUpdateDate(roleDetails.getUpdateDate());

		return roleDetailsDTO;
	}
	
	public RoleDetailsDTO createOne(HeaderRequestDTO headerRequestDTO, RoleDetailsDTO roleDetailsDTO) {
		RoleDetails roleDetails = new RoleDetails();
		roleDetails.setName(roleDetailsDTO.getName());
		roleDetails.setCreateDate(new Date());
		roleDetails = roleDetailsDao.save(roleDetails);

		roleDetailsDTO = new RoleDetailsDTO();
		roleDetailsDTO.setIdRole(roleDetails.getIdRole());
		roleDetailsDTO.setName(roleDetails.getName());
		roleDetailsDTO.setCreateDate(roleDetails.getCreateDate());
		roleDetailsDTO.setUpdateDate(roleDetails.getUpdateDate());

		return roleDetailsDTO;
	}
	
	public RoleDetailsDTO updateOne(HeaderRequestDTO headerRequestDTO, RoleDetailsDTO roleDetailsDTO) {
		RoleDetails roleDetails = roleDetailsDao.findOneById(roleDetailsDTO.getIdRole());
		if (roleDetails == null) {
			throw new ServiceErrorException("RoleDetails [IdRole: " + roleDetailsDTO.getIdRole() + "] not exists");
		}
		
		roleDetails.setName(roleDetailsDTO.getName());
		roleDetails.setUpdateDate(new Date());
		roleDetails = roleDetailsDao.save(roleDetails);
		
		roleDetailsDTO = new RoleDetailsDTO();
		roleDetailsDTO.setIdRole(roleDetails.getIdRole());
		roleDetailsDTO.setName(roleDetails.getName());
		roleDetailsDTO.setCreateDate(roleDetails.getCreateDate());
		roleDetailsDTO.setUpdateDate(roleDetails.getUpdateDate());

		return roleDetailsDTO;
	}
	
	public void deleteOne(HeaderRequestDTO headerRequestDTO, RoleDetailsDTO roleDetailsDTO) {
		RoleDetails roleDetails = roleDetailsDao.findOneById(roleDetailsDTO.getIdRole());
		if (roleDetails == null) {
			throw new ServiceErrorException("RoleDetails [IdRole: " + roleDetailsDTO.getIdRole() + "] not exists");
		}

		roleDetailsDao.delete(roleDetails);
	}

}
