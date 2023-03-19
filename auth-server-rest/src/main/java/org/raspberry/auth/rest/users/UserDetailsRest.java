package org.raspberry.auth.rest.users;

import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameRequestDTO;
import org.raspberry.auth.dto.operation.userdetails.FindOneByUsernameResponseDTO;
import org.raspberry.auth.service.users.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsRest {

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/api/userDetails/findOneByUsername")
	public ResponseEntity<FindOneByUsernameResponseDTO> findOneByUsername(RequestEntity<FindOneByUsernameRequestDTO> requestEntityDTO) {
		FindOneByUsernameRequestDTO requestDTO = requestEntityDTO.getBody();

		FindOneByUsernameResponseDTO responseDTO = userDetailsService.findOneByUsername(requestDTO);

		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

}