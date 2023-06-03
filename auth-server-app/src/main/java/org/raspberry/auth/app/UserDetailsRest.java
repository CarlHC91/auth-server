package org.raspberry.auth.app;

import java.util.List;

import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_IN;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_OUT;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_OUT;
import org.raspberry.auth.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsRest {

	@Autowired
	private UserDetailsService userDetailsService;

	@PreAuthorize("hasAuthority('/auth/userDetails/findAll')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/findAll")
	public ResponseEntity<FindAll_OUT> findAll(RequestEntity<FindAll_IN> requestEntityDTO) {
		List<UserDetailsVO> userDetailsListVO = userDetailsService.findAll();

		FindAll_OUT findAll_OUT = new FindAll_OUT();
		findAll_OUT.setUserDetailsList(userDetailsListVO);

		return ResponseEntity.status(HttpStatus.OK).body(findAll_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userDetails/createOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/createOne")
	public ResponseEntity<CreateOne_OUT> createOne(RequestEntity<CreateOne_IN> requestEntityDTO) {
		CreateOne_IN createOne_IN = requestEntityDTO.getBody();

		UserDetailsVO userDetailsVO = userDetailsService.createOne(createOne_IN.getUserDetails());

		CreateOne_OUT createOne_OUT = new CreateOne_OUT();
		createOne_OUT.setUserDetails(userDetailsVO);

		return ResponseEntity.status(HttpStatus.OK).body(createOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userDetails/updateOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/updateOne")
	public ResponseEntity<UpdateOne_OUT> updateOne(RequestEntity<UpdateOne_IN> requestEntityDTO) {
		UpdateOne_IN updateOne_IN = requestEntityDTO.getBody();

		UserDetailsVO userDetailsVO = userDetailsService.updateOne(updateOne_IN.getUserDetails());

		UpdateOne_OUT updateOne_OUT = new UpdateOne_OUT();
		updateOne_OUT.setUserDetails(userDetailsVO);

		return ResponseEntity.status(HttpStatus.OK).body(updateOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/userDetails/deleteOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/deleteOne")
	public ResponseEntity<DeleteOne_OUT> deleteOne(RequestEntity<DeleteOne_IN> requestEntityDTO) {
		DeleteOne_IN deleteOne_IN = requestEntityDTO.getBody();

		userDetailsService.deleteOne(deleteOne_IN.getUserDetails());

		DeleteOne_OUT deleteOne_OUT = new DeleteOne_OUT();

		return ResponseEntity.status(HttpStatus.OK).body(deleteOne_OUT);
	}

}
