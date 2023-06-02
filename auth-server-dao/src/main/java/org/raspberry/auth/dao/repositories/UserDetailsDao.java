package org.raspberry.auth.dao.repositories;

import org.raspberry.auth.model.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Long> {

	@Query("SELECT entity FROM UserDetails entity WHERE entity.tokenApi = :tokenApi")
	public UserDetails findOneByTokenApi(@Param("tokenApi") String tokenApi);

	@Query("SELECT entity FROM UserDetails entity WHERE entity.username = :username AND entity.password = :password")
	public UserDetails findOneByUsername(@Param("username") String username, @Param("password") String password);

}
