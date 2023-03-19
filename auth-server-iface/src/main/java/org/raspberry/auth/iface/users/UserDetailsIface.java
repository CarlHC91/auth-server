package org.raspberry.auth.iface.users;

import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameRequestDTO;
import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDetailsIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public FindOneByUsernameResponseDTO findOneByUsername(FindOneByUsernameRequestDTO findOneByUsernameRequestDTO) {
		String url = path + "/api/userDetails/findOneByUsername";

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, findOneByUsernameRequestDTO, FindOneByUsernameResponseDTO.class);
	}

}