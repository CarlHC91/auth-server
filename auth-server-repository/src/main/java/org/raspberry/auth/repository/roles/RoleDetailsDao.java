package org.raspberry.auth.repository.roles;

import org.raspberry.auth.model.roles.RoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDetailsDao extends JpaRepository<RoleDetails, Long> {

	@Query("SELECT entity FROM RoleDetails entity WHERE entity.idRole = :idRole")
	public RoleDetails findOneById(@Param("idRole") Long idRole);

}
