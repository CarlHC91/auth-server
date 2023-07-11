package org.raspberry.auth.iface.user;

import java.util.HashMap;
import java.util.Map;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserAuthorityIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public UserAuthorityVO findOneById(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		String url = path + "/userAuthority/findOneById?token_api={token_api}&id_authority={id_authority}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_authority", userAuthorityVO.getIdAuthority());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserAuthorityVO.class, params);
	}
		
	public UserAuthorityVO[] findAllByUser(UserDetailsVO userSessionVO, UserDetailsVO userDetailsVO) {
		String url = path + "/userAuthority/findAllByUser?token_api={token_api}&id_user={id_user}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_user", userDetailsVO.getIdUser());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserAuthorityVO[].class, params);
	}

	public UserAuthorityVO createOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		String url = path + "/userAuthority/createOne?token_api={token_api}&id_user={id_user}&name={name}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_user", userAuthorityVO.getIdUser());
		params.put("name", userAuthorityVO.getName());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserAuthorityVO.class, params);
	}

	public UserAuthorityVO updateOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		String url = path + "/userAuthority/updateOne?token_api={token_api}&id_authority={id_authority}&id_user={id_user}&name={name}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_authority", userAuthorityVO.getIdAuthority());
		params.put("id_user", userAuthorityVO.getIdUser());
		params.put("name", userAuthorityVO.getName());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, null, UserAuthorityVO.class, params);
	}

	public void deleteOne(UserDetailsVO userSessionVO, UserAuthorityVO userAuthorityVO) {
		String url = path + "/userAuthority/deleteOne?token_api={token_api}&id_authority={id_authority}";

		Map<String, Object> params = new HashMap<>();
		params.put("token_api", userSessionVO.getTokenApi());
		params.put("id_authority", userAuthorityVO.getIdAuthority());

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, null, Void.class, params);
	}

}
