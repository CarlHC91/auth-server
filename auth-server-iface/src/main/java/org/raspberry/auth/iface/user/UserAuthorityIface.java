package org.raspberry.auth.iface.user;

import java.util.List;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.pojos.operations.userauthority.CreateOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.userauthority.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.userauthority.FindAllByUser_IN;
import org.raspberry.auth.pojos.operations.userauthority.FindAllByUser_OUT;
import org.raspberry.auth.pojos.operations.userauthority.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.userauthority.UpdateOne_OUT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserAuthorityIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public List<UserAuthorityVO> findAllByUser(UserDetailsVO userDetailsVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userAuthority/findAllByUser?token_api=" + authentication.getPrincipal();

		FindAllByUser_IN findAllByUser_IN = new FindAllByUser_IN();
		findAllByUser_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		FindAllByUser_OUT findAllByUser_OUT = restTemplate.postForObject(url, findAllByUser_IN, FindAllByUser_OUT.class);

		return findAllByUser_OUT.getUserAuthorityList();
	}

	public UserAuthorityVO createOne(UserAuthorityVO userAuthorityVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userAuthority/createOne?token_api=" + authentication.getPrincipal();

		CreateOne_IN createOne_IN = new CreateOne_IN();
		createOne_IN.setUserAuthority(userAuthorityVO);

		RestTemplate restTemplate = new RestTemplate();
		CreateOne_OUT createOne_OUT = restTemplate.postForObject(url, createOne_IN, CreateOne_OUT.class);

		return createOne_OUT.getUserAuthority();
	}

	public UserAuthorityVO updateOne(UserAuthorityVO userAuthorityVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userAuthority/updateOne?token_api=" + authentication.getPrincipal();

		UpdateOne_IN updateOne_IN = new UpdateOne_IN();
		updateOne_IN.setUserAuthority(userAuthorityVO);

		RestTemplate restTemplate = new RestTemplate();
		UpdateOne_OUT updateOne_OUT = restTemplate.postForObject(url, updateOne_IN, UpdateOne_OUT.class);

		return updateOne_OUT.getUserAuthority();
	}

	public void deleteOne(UserAuthorityVO userAuthorityVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userAuthority/deleteOne?token_api=" + authentication.getPrincipal();

		DeleteOne_IN deleteOne_IN = new DeleteOne_IN();
		deleteOne_IN.setUserAuthority(userAuthorityVO);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, deleteOne_IN, DeleteOne_OUT.class);
	}

}
