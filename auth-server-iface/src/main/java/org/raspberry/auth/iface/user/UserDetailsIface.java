package org.raspberry.auth.iface.user;

import java.util.List;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_IN;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_OUT;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_OUT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDetailsIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public List<UserDetailsVO> findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userDetails/findAll?token_api=" + authentication.getPrincipal();

		FindAll_IN findAll_IN = new FindAll_IN();

		RestTemplate restTemplate = new RestTemplate();
		FindAll_OUT findAll_OUT = restTemplate.postForObject(url, findAll_IN, FindAll_OUT.class);

		return findAll_OUT.getUserDetailsList();
	}
	
	public UserDetailsVO createOne(UserDetailsVO userDetailsVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userDetails/createOne?token_api=" + authentication.getPrincipal();

		CreateOne_IN createOne_IN = new CreateOne_IN();
		createOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		CreateOne_OUT createOne_OUT = restTemplate.postForObject(url, createOne_IN, CreateOne_OUT.class);

		return createOne_OUT.getUserDetails();
	}
	
	public UserDetailsVO updateOne(UserDetailsVO userDetailsVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userDetails/updateOne?token_api=" + authentication.getPrincipal();

		UpdateOne_IN updateOne_IN = new UpdateOne_IN();
		updateOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		UpdateOne_OUT updateOne_OUT = restTemplate.postForObject(url, updateOne_IN, UpdateOne_OUT.class);

		return updateOne_OUT.getUserDetails();
	}
	
	public void deleteOne(UserDetailsVO userDetailsVO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String url = path + "/userDetails/deleteOne?token_api=" + authentication.getPrincipal();

		DeleteOne_IN deleteOne_IN = new DeleteOne_IN();
		deleteOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, deleteOne_IN, DeleteOne_OUT.class);
	}
	
}
