package org.raspberry.auth.iface.webdav;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.pojos.entities.webdav.WebdavDirectoryVO;
import org.raspberry.auth.pojos.operations.webdavdirectory.CreateOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.FindOneByUser_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.FindOneByUser_OUT;
import org.raspberry.auth.pojos.operations.webdavdirectory.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.webdavdirectory.UpdateOne_OUT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebdavDirectoryIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public WebdavDirectoryVO findOneByUser(UserDetailsVO userDetailsVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/webdavDirectory/findOneByUser?token_api=" + authentication.getPrincipal();

		FindOneByUser_IN findOneByUser_IN = new FindOneByUser_IN();
		findOneByUser_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		FindOneByUser_OUT findOneByUser_OUT = restTemplate.postForObject(url, findOneByUser_IN,
				FindOneByUser_OUT.class);

		return findOneByUser_OUT.getWebdavDirectory();
	}

	public WebdavDirectoryVO createOne(WebdavDirectoryVO webdavDirectoryVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/webdavDirectory/createOne?token_api=" + authentication.getPrincipal();

		CreateOne_IN createOne_IN = new CreateOne_IN();
		createOne_IN.setWebdavDirectory(webdavDirectoryVO);

		RestTemplate restTemplate = new RestTemplate();
		CreateOne_OUT createOne_OUT = restTemplate.postForObject(url, createOne_IN, CreateOne_OUT.class);

		return createOne_OUT.getWebdavDirectory();
	}

	public WebdavDirectoryVO updateOne(WebdavDirectoryVO webdavDirectoryVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/webdavDirectory/updateOne?token_api=" + authentication.getPrincipal();

		UpdateOne_IN updateOne_IN = new UpdateOne_IN();
		updateOne_IN.setWebdavDirectory(webdavDirectoryVO);

		RestTemplate restTemplate = new RestTemplate();
		UpdateOne_OUT updateOne_OUT = restTemplate.postForObject(url, updateOne_IN, UpdateOne_OUT.class);

		return updateOne_OUT.getWebdavDirectory();
	}

	public void deleteOne(WebdavDirectoryVO webdavDirectoryVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/webdavDirectory/deleteOne?token_api=" + authentication.getPrincipal();

		DeleteOne_IN deleteOne_IN = new DeleteOne_IN();
		deleteOne_IN.setWebdavDirectory(webdavDirectoryVO);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, deleteOne_IN, DeleteOne_OUT.class);
	}

}
