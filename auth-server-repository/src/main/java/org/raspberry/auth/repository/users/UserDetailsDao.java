package org.raspberry.auth.repository.users;

import org.raspberry.auth.model.users.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Long> {

	@Query("SELECT entity FROM UserDetails entity WHERE entity.idUser = :idUser")
	public UserDetails findOneById(@Param("idUser") Long idUser);

	@Query("SELECT entity FROM UserDetails entity WHERE entity.tokenApi = :tokenApi")
	public UserDetails findOneByTokenApi(@Param("tokenApi") String tokenApi);

	@Query("SELECT entity FROM UserDetails entity WHERE entity.username = :username AND entity.password = :password")
	public UserDetails findOneByUsername(@Param("username") String username, @Param("password") String password);

}
