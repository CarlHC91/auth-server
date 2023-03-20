package org.raspberry.auth.iface.users;

import org.raspberry.auth.dto.operation.userpermission.FindOneByFilterRequestDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByFilterResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserPermissionIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public FindOneByFilterResponseDTO findOneByFilter(FindOneByFilterRequestDTO findOneByFilterRequestDTO) {
		String url = path + "/api/userPermission/findOneByFilter";

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, findOneByFilterRequestDTO, FindOneByFilterResponseDTO.class);
	}

}