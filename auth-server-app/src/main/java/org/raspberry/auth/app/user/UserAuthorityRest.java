package org.raspberry.auth.app.user;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.service.user.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthorityRest {

	@Autowired
	private UserAuthorityService userAuthorityService;

	@PostMapping("/userAuthority/findOneById")
	@PreAuthorize("hasAuthority('/auth/userAuthority/findOneById')")
	public UserAuthorityVO findOneById(@RequestParam("id_authority") Long idAuthority) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(idAuthority);

		return userAuthorityService.findOneById(userSessionVO, userAuthorityVO);
	}

	@PostMapping("/userAuthority/findAllByUser")
	@PreAuthorize("hasAuthority('/auth/userAuthority/findAllByUser')")
	public UserAuthorityVO[] findAllByUser(@RequestParam("id_user") Long idUser) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(idUser);

		return userAuthorityService.findAllByUser(userSessionVO, userDetailsVO);
	}

	@PostMapping("/userAuthority/createOne")
	@PreAuthorize("hasAuthority('/auth/userAuthority/createOne')")
	public UserAuthorityVO createOne(@RequestParam("id_user") Long idUser, @RequestParam("name") String name) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdUser(idUser);
		userAuthorityVO.setName(name);

		return userAuthorityService.createOne(userSessionVO, userAuthorityVO);
	}
	
	@PostMapping("/userAuthority/updateOne")
	@PreAuthorize("hasAuthority('/auth/userAuthority/updateOne')")
	public UserAuthorityVO updateOne(@RequestParam("id_authority") Long idAuthority, @RequestParam("id_user") Long idUser, @RequestParam("name") String name) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(idAuthority);
		userAuthorityVO.setIdUser(idUser);
		userAuthorityVO.setName(name);

		return userAuthorityService.updateOne(userSessionVO, userAuthorityVO);
	}
	
	@PostMapping("/userAuthority/deleteOne")
	@PreAuthorize("hasAuthority('/auth/userAuthority/deleteOne')")
	public void deleteOne(@RequestParam("id_authority") Long idAuthority) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO userSessionVO = (UserDetailsVO) authentication.getPrincipal();

		UserAuthorityVO userAuthorityVO = new UserAuthorityVO();
		userAuthorityVO.setIdAuthority(idAuthority);

		userAuthorityService.deleteOne(userSessionVO, userAuthorityVO);
	}

}
