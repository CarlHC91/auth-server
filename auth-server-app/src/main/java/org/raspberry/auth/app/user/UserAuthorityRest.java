package org.raspberry.auth.app.user;

import java.util.List;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.operations.userauthority.CreateOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.userauthority.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.userauthority.FindAllByUser_IN;
import org.raspberry.auth.pojos.operations.userauthority.FindAllByUser_OUT;
import org.raspberry.auth.pojos.operations.userauthority.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.UpdateOne_OUT;
import org.raspberry.auth.service.user.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthorityRest {

	@Autowired
	private UserAuthorityService userAuthorityService;

	@PreAuthorize("hasAuthority('/auth/userAuthority/findAllByUser')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userAuthority/findAllByUser")
	public ResponseEntity<FindAllByUser_OUT> findAllByUser(RequestEntity<FindAllByUser_IN> requestEntityDTO) {
		FindAllByUser_IN findAllByUser_IN = requestEntityDTO.getBody();

		List<UserAuthorityVO> userAuthorityListVO = userAuthorityService.findAllByUser(findAllByUser_IN.getUserDetails());

		FindAllByUser_OUT findAllByUser_OUT = new FindAllByUser_OUT();
		findAllByUser_OUT.setUserAuthorityList(userAuthorityListVO);

		return ResponseEntity.status(HttpStatus.OK).body(findAllByUser_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userAuthority/createOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userAuthority/createOne")
	public ResponseEntity<CreateOne_OUT> createOne(RequestEntity<CreateOne_IN> requestEntityDTO) {
		CreateOne_IN createOne_IN = requestEntityDTO.getBody();

		UserAuthorityVO userAuthorityVO = userAuthorityService.createOne(createOne_IN.getUserAuthority());

		CreateOne_OUT createOne_OUT = new CreateOne_OUT();
		createOne_OUT.setUserAuthority(userAuthorityVO);

		return ResponseEntity.status(HttpStatus.OK).body(createOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userAuthority/updateOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userAuthority/updateOne")
	public ResponseEntity<UpdateOne_OUT> updateOne(RequestEntity<UpdateOne_IN> requestEntityDTO) {
		UpdateOne_IN updateOne_IN = requestEntityDTO.getBody();

		UserAuthorityVO userAuthorityVO = userAuthorityService.updateOne(updateOne_IN.getUserAuthority());

		UpdateOne_OUT updateOne_OUT = new UpdateOne_OUT();
		updateOne_OUT.setUserAuthority(userAuthorityVO);

		return ResponseEntity.status(HttpStatus.OK).body(updateOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userAuthority/deleteOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userAuthority/deleteOne")
	public ResponseEntity<DeleteOne_OUT> deleteOne(RequestEntity<DeleteOne_IN> requestEntityDTO) {
		DeleteOne_IN deleteOne_IN = requestEntityDTO.getBody();

		userAuthorityService.deleteOne(deleteOne_IN.getUserAuthority());

		DeleteOne_OUT deleteOne_OUT = new DeleteOne_OUT();

		return ResponseEntity.status(HttpStatus.OK).body(deleteOne_OUT);
	}

}
