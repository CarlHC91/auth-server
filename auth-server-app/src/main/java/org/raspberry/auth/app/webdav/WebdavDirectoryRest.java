package org.raspberry.auth.app.webdav;

import org.raspberry.auth.pojos.entities.webdav.WebdavDirectoryVO;
import org.raspberry.auth.pojos.operations.webdavdirectory.CreateOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.FindOneByUser_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.FindOneByUser_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.UpdateOne_OUT;
import org.raspberry.auth.service.webdav.WebdavDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebdavDirectoryRest {

	@Autowired
	private WebdavDirectoryService webdavDirectoryService;

	@PreAuthorize("hasAuthority('/auth/webdavDirectory/findOneByUser')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/webdavDirectory/findOneByUser")
	public ResponseEntity<FindOneByUser_OUT> findOneByUser(RequestEntity<FindOneByUser_IN> requestEntityDTO) {
		FindOneByUser_IN findOneByUser_IN = requestEntityDTO.getBody();

		WebdavDirectoryVO webdavDirectoryVO = webdavDirectoryService.findOneByUser(findOneByUser_IN.getUserDetails());

		FindOneByUser_OUT findOneByUser_OUT = new FindOneByUser_OUT();
		findOneByUser_OUT.setWebdavDirectory(webdavDirectoryVO);

		return ResponseEntity.status(HttpStatus.OK).body(findOneByUser_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/webdavDirectory/createOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/webdavDirectory/createOne")
	public ResponseEntity<CreateOne_OUT> createOne(RequestEntity<CreateOne_IN> requestEntityDTO) {
		CreateOne_IN createOne_IN = requestEntityDTO.getBody();

		WebdavDirectoryVO webdavDirectoryVO = webdavDirectoryService.createOne(createOne_IN.getWebdavDirectory());

		CreateOne_OUT createOne_OUT = new CreateOne_OUT();
		createOne_OUT.setWebdavDirectory(webdavDirectoryVO);

		return ResponseEntity.status(HttpStatus.OK).body(createOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/webdavDirectory/updateOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/webdavDirectory/updateOne")
	public ResponseEntity<UpdateOne_OUT> updateOne(RequestEntity<UpdateOne_IN> requestEntityDTO) {
		UpdateOne_IN updateOne_IN = requestEntityDTO.getBody();

		WebdavDirectoryVO webdavDirectoryVO = webdavDirectoryService.updateOne(updateOne_IN.getWebdavDirectory());

		UpdateOne_OUT updateOne_OUT = new UpdateOne_OUT();
		updateOne_OUT.setWebdavDirectory(webdavDirectoryVO);

		return ResponseEntity.status(HttpStatus.OK).body(updateOne_OUT);
	}

	@PreAuthorize("hasAuthority('/auth/webdavDirectory/deleteOne')")
	@PostMapping(produces = "application/json", consumes = "application/json", value = "/webdavDirectory/deleteOne")
	public ResponseEntity<DeleteOne_OUT> deleteOne(RequestEntity<DeleteOne_IN> requestEntityDTO) {
		DeleteOne_IN deleteOne_IN = requestEntityDTO.getBody();

		webdavDirectoryService.deleteOne(deleteOne_IN.getWebdavDirectory());

		DeleteOne_OUT deleteOne_OUT = new DeleteOne_OUT();

		return ResponseEntity.status(HttpStatus.OK).body(deleteOne_OUT);
	}

}
