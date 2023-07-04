package org.raspberry.auth.app.user;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.pojos.operations.usersession.FindOneByTokenApi_IN;
import org.raspberry.auth.pojos.operations.usersession.FindOneByTokenApi_OUT;
import org.raspberry.auth.service.user.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSessionRest {

	@Autowired
	private UserSessionService userSessionService;

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userSession/findOneByTokenApi")
	public ResponseEntity<FindOneByTokenApi_OUT> findOneByTokenApi(RequestEntity<FindOneByTokenApi_IN> requestEntityDTO) {
		FindOneByTokenApi_IN findOneByTokenApi_IN = requestEntityDTO.getBody();

		UserDetailsVO userDetailsVO = userSessionService.findOneByTokenApi(findOneByTokenApi_IN.getUserDetails());

		FindOneByTokenApi_OUT findOneByTokenApi_OUT = new FindOneByTokenApi_OUT();
		findOneByTokenApi_OUT.setUserDetails(userDetailsVO);

		return ResponseEntity.status(HttpStatus.OK).body(findOneByTokenApi_OUT);
	}

}
