package org.raspberry.auth.iface.user;

import java.util.HashMap;
import java.util.Map;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDetailsIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public UserDetailsVO findOneById(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		String url = path + "/userDetails/findOneById?token_api={token_api}&id_user={id_user}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_user", userDetailsVO.getIdUser());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO.class, params);
	}
	
	public UserDetailsVO[] findAll(UserDetailsVO userSessionVO) {
		String url = path + "/userDetails/findAll?token_api={token_api}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO[].class, params);
	}
	
	public UserDetailsVO createOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		String url = path + "/userDetails/createOne?token_api={token_api}&username={username}&password={password}&first_name={first_name}&last_name={last_name}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("username", userDetailsVO.getUsername());
		params.put("password", userDetailsVO.getPassword());
		params.put("first_name", userDetailsVO.getFirstName());
		params.put("last_name", userDetailsVO.getLastName());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO.class, params);
	}
	
	public UserDetailsVO updateOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		String url = path + "/userDetails/updateOne?token_api={token_api}&id_user={id_user}&username={username}&password={password}&first_name={first_name}&last_name={last_name}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_user", userDetailsVO.getIdUser());
		params.put("username", userDetailsVO.getUsername());
		params.put("password", userDetailsVO.getPassword());
		params.put("first_name", userDetailsVO.getFirstName());
		params.put("last_name", userDetailsVO.getLastName());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserDetailsVO.class, params);
	}
	
	public void deleteOne(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		String url = path + "/userDetails/deleteOne?token_api={token_api}&id_user={id_user}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_user", userDetailsVO.getIdUser());

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, null, Void.class, params);
	}
	
}
