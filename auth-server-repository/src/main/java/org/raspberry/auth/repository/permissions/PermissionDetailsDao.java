package org.raspberry.auth.repository.permissions;

import org.raspberry.auth.model.permissions.PermissionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDetailsDao extends JpaRepository<PermissionDetails, Long> {

	@Query("SELECT entity FROM PermissionDetails entity WHERE entity.servicePath = :servicePath")
	public PermissionDetails findOneByServicePath(@Param("servicePath") String servicePath);

}
