package org.raspberry.auth.app.user;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.service.user.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSessionRest {

	@Autowired
	private UserSessionService userSessionService;

	@PostMapping("/userSession/findOneByTokenApi")
	public UserDetailsVO findOneByTokenApi(@RequestParam("token_api") String tokenApi) {
		UserDetailsVO userSessionVO = new UserDetailsVO();
		userSessionVO.setTokenApi(tokenApi);

		return userSessionService.findOneByTokenApi(userSessionVO);
	}

	@PostMapping("/userSession/findOneByUsername")
	public UserDetailsVO findOneByUsername(@RequestParam("username") String username, @RequestParam("password") String password) {
		UserDetailsVO userSessionVO = new UserDetailsVO();
		userSessionVO.setUsername(username);
		userSessionVO.setPassword(password);

		return userSessionService.findOneByUsername(userSessionVO);
	}
	
}
