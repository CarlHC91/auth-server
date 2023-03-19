package org.raspberry.auth.rest.users;

import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathRequestDTO;
import org.raspberry.auth.dto.operation.userpermission.FindOneByServicePathResponseDTO;
import org.raspberry.auth.service.users.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPermissionRest {

	@Autowired
	private UserPermissionService userPermissionService;

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/api/userPermission/findOneByServicePath")
	public ResponseEntity<FindOneByServicePathResponseDTO> findOneByServicePath(RequestEntity<FindOneByServicePathRequestDTO> requestEntityDTO) {
		FindOneByServicePathRequestDTO requestDTO = requestEntityDTO.getBody();

		FindOneByServicePathResponseDTO responseDTO = userPermissionService.findOneByServicePath(requestDTO);

		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

}