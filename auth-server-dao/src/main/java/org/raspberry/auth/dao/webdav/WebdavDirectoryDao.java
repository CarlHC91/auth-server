package org.raspberry.auth.dao.webdav;

import org.raspberry.auth.model.webdav.WebdavDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WebdavDirectoryDao extends JpaRepository<WebdavDirectory, Long> {

	@Query("SELECT entity FROM WebdavDirectory entity WHERE entity.idDirectory = :idDirectory")
	public WebdavDirectory findOneById(@Param("idDirectory") Long idDirectory);

	@Query("SELECT entity FROM WebdavDirectory entity WHERE entity.idUser = :idUser")
	public WebdavDirectory findOneByUser(@Param("idUser") Long idUser);

}
