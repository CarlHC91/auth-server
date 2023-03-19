package org.raspberry.auth.repository.users;

import org.raspberry.auth.model.users.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionDao extends JpaRepository<UserPermission, Long> {

	@Query("SELECT entity FROM UserPermission entity WHERE entity.idUser = :idUser AND entity.servicePath = :servicePath")
	public UserPermission findOneByServicePath(@Param("idUser") Long idUser, @Param("servicePath") String servicePath);

}
