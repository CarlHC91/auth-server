package org.raspberry.auth.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.raspberry.auth.pojos.entities.user.UserAuthorityVO;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.service.user.UserAuthorityService;
import org.raspberry.auth.service.user.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	private UserAuthorityService userAuthorityService;
	@Autowired
	private UserSessionService userSessionService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String tokenApi = request.getParameter("token_api");

		if (tokenApi != null) {
			UserDetailsVO userDetailsVO = new UserDetailsVO();
			userDetailsVO.setTokenApi(tokenApi);
			
			userDetailsVO = userSessionService.findOneByTokenApi(userDetailsVO);
			if (userDetailsVO != null) {
				List<GrantedAuthority> authorityList = new ArrayList<>();
				
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(tokenApi, null, authorityList));
				
				for (UserAuthorityVO userAuthorityVO : userAuthorityService.findAllByUser(userDetailsVO)) {
					GrantedAuthority authority = new SimpleGrantedAuthority(userAuthorityVO.getName());
					
					authorityList.add(authority);
				}
				
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(tokenApi, null, authorityList));
			}
		}

		filterChain.doFilter(request, response);
	}

}