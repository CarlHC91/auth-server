package org.raspberry.auth.iface;

import java.util.List;

import org.raspberry.auth.pojos.entities.RequestHeaderVO;
import org.raspberry.auth.pojos.entities.UserDetailsVO;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.CreateOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.DeleteOne_OUT;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_IN;
import org.raspberry.auth.pojos.operations.userdetails.FindAll_OUT;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_IN;
import org.raspberry.auth.pojos.operations.userdetails.UpdateOne_OUT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDetailsIface {

	@Value("${iface.server.auth.path}")
	private String path;

	public List<UserDetailsVO> findAll(RequestHeaderVO requestHeaderVO) {
		String url = path + "/api/userDetails/findAll";

		FindAll_IN findAll_IN = new FindAll_IN();
		findAll_IN.setRequestHeader(requestHeaderVO);

		RestTemplate restTemplate = new RestTemplate();
		FindAll_OUT findAll_OUT = restTemplate.postForObject(url, findAll_IN, FindAll_OUT.class);

		return findAll_OUT.getUserDetailsList();
	}
	
	public UserDetailsVO createOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		String url = path + "/api/userDetails/createOne";

		CreateOne_IN createOne_IN = new CreateOne_IN();
		createOne_IN.setRequestHeader(requestHeaderVO);
		createOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		CreateOne_OUT createOne_OUT = restTemplate.postForObject(url, createOne_IN, CreateOne_OUT.class);

		return createOne_OUT.getUserDetails();
	}
	
	public UserDetailsVO updateOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		String url = path + "/api/userDetails/updateOne";

		UpdateOne_IN updateOne_IN = new UpdateOne_IN();
		updateOne_IN.setRequestHeader(requestHeaderVO);
		updateOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		UpdateOne_OUT updateOne_OUT = restTemplate.postForObject(url, updateOne_IN, UpdateOne_OUT.class);

		return updateOne_OUT.getUserDetails();
	}
	
	public void deleteOne(RequestHeaderVO requestHeaderVO, UserDetailsVO userDetailsVO) {
		String url = path + "/api/userDetails/deleteOne";

		DeleteOne_IN deleteOne_IN = new DeleteOne_IN();
		deleteOne_IN.setRequestHeader(requestHeaderVO);
		deleteOne_IN.setUserDetails(userDetailsVO);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, deleteOne_IN, DeleteOne_OUT.class);
	}
	
}
