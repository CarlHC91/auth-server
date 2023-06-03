package org.raspberry.auth.dao.repositories;

import java.util.List;

import org.raspberry.auth.model.entities.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityDao extends JpaRepository<UserAuthority, Long> {

	@Query("SELECT entity FROM UserAuthority entity WHERE entity.idAuthority = :idAuthority")
	public UserAuthority findOneById(@Param("idAuthority") Long idAuthority);
	
	@Query("SELECT entity FROM UserAuthority entity WHERE entity.idUser = :idUser")
	public List<UserAuthority> findAllByUser(@Param("idUser") Long idUser);

}
