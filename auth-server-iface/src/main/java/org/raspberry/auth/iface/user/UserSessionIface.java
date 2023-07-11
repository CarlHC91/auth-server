package org.raspberry.auth.iface.user;

import java.util.HashMap;
import java.util.Map;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserSessionIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public UserDetailsVO findOneByTokenApi(UserDetailsVO userSessionVO) {
		String url = path + "/userSession/findOneByTokenApi?token_api={token_api}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO.class, params);
	}
	
	public UserDetailsVO findOneByUsername(UserDetailsVO userSessionVO) {
		String url = path + "/userSession/findOneByUsername?username={username}&password={password}";

		Map<String, Object> params = new HashMap<>();
		params.put("username", userSessionVO.getUsername());
		params.put("password", userSessionVO.getPassword());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO.class, params);
	}

}
