package org.raspberry.auth.repository.users;

import org.raspberry.auth.model.users.UserPermission;
import org.raspberry.auth.model.users.UserPermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionDao extends JpaRepository<UserPermission, UserPermissionPK> {

	@Query("SELECT entity FROM UserPermission entity WHERE entity.idUser = :idUser AND entity.idPermission = :idPermission")
	public UserPermission findOneById(@Param("idUser") Long idUser, @Param("idPermission") Long idPermission);

}
