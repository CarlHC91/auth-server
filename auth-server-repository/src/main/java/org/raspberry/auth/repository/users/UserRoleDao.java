package org.raspberry.auth.repository.users;

import org.raspberry.auth.model.users.UserRole;
import org.raspberry.auth.model.users.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, UserRolePK> {

	@Query("SELECT entity FROM UserRole entity WHERE entity.idUser = :idUser AND entity.idRole = :idRole")
	public UserRole findOneById(@Param("idUser") Long idUser, @Param("idRole") Long idRole);

}
