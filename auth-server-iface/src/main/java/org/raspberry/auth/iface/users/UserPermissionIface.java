package org.raspberry.auth.iface.users;

import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathRequestDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserPermissionIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public FindOneByServicePathResponseDTO findOneByServicePath(FindOneByServicePathRequestDTO findOneByServicePathRequestDTO) {
		String url = path + "/api/userPermission/findOneByServicePath";

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, findOneByServicePathRequestDTO, FindOneByServicePathResponseDTO.class);
	}

}