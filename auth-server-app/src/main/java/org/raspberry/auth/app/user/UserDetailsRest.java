package org.raspberry.auth.app.user;

import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.service.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsRest {

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/userDetails/findOneById")
	@PreAuthorize("hasDetails('/auth/userDetails/findOneById')")
	public UserDetailsVO findOneById(@RequestParam("id_user") Long idUser) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(idUser);

		return userDetailsService.findOneById(userSessionVO, userDetailsVO);
	}

	@PostMapping("/userDetails/findAll")
	@PreAuthorize("hasDetails('/auth/userDetails/findAll')")
	public UserDetailsVO[] findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		return userDetailsService.findAll(userSessionVO);
	}

	@PostMapping("/userDetails/createOne")
	@PreAuthorize("hasDetails('/auth/userDetails/createOne')")
	public UserDetailsVO createOne(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setUsername(username);
		userDetailsVO.setPassword(password);
		userDetailsVO.setFirstName(firstName);
		userDetailsVO.setLastName(lastName);

		return userDetailsService.createOne(userSessionVO, userDetailsVO);
	}
	
	@PostMapping("/userDetails/updateOne")
	@PreAuthorize("hasDetails('/auth/userDetails/updateOne')")
	public UserDetailsVO updateOne(@RequestParam("id_user") Long idUser, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(idUser);
		userDetailsVO.setUsername(username);
		userDetailsVO.setPassword(password);
		userDetailsVO.setFirstName(firstName);
		userDetailsVO.setLastName(lastName);

		return userDetailsService.updateOne(userSessionVO, userDetailsVO);
	}
	
	@PostMapping("/userDetails/deleteOne")
	@PreAuthorize("hasDetails('/auth/userDetails/deleteOne')")
	public void deleteOne(@RequestParam("id_user") Long idUser) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(idUser);

		userDetailsService.deleteOne(userSessionVO, userDetailsVO);
	}

}
