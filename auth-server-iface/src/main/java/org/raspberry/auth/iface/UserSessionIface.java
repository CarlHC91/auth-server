package org.raspberry.auth.iface;

import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.raspberry.auth.pojos.operations.usersession.FindOneByTokenApi_IN;
import org.raspberry.auth.pojos.operations.usersession.FindOneByTokenApi_OUT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserSessionIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public UserDetailsVO findOneByTokenApi(RequestHeaderVO requestHeaderVO) {
		String url = path + "/api/userSession/findOneByTokenApi";

		FindOneByTokenApi_IN findOneByTokenApi_IN = new FindOneByTokenApi_IN();
		findOneByTokenApi_IN.setRequestHeader(requestHeaderVO);

		RestTemplate restTemplate = new RestTemplate();
		FindOneByTokenApi_OUT findOneByTokenApi_OUT = restTemplate.postForObject(url, findOneByTokenApi_IN, FindOneByTokenApi_OUT.class);

		return findOneByTokenApi_OUT.getUserDetails();
	}

}
