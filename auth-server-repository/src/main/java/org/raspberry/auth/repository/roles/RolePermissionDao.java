package org.raspberry.auth.repository.roles;

import org.raspberry.auth.model.roles.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao extends JpaRepository<RolePermission, Long> {

	@Query("SELECT entity FROM RolePermission entity WHERE entity.idPermission = :idPermission")
	public RolePermission findOneById(@Param("idPermission") Long idPermission);

	@Query("SELECT entity FROM RolePermission entity WHERE entity.servicePath = :servicePath")
	public RolePermission findOneByServicePath(@Param("servicePath") String servicePath);

}
