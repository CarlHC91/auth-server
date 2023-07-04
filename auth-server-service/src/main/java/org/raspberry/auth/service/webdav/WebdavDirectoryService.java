package org.raspberry.auth.service.webdav;

import org.raspberry.auth.dao.webdav.WebdavDirectoryDao;
import org.raspberry.auth.exception.ServiceException;
import org.raspberry.auth.model.webdav.WebdavDirectory;
import org.raspberry.auth.pojos.entities.user.UserDetailsVO;
import org.raspberry.auth.pojos.entities.webdav.WebdavDirectoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebdavDirectoryService {

	@Autowired
	private WebdavDirectoryDao webdavDirectoryDao;

	public WebdavDirectoryVO findOneByUser(UserDetailsVO userDetailsVO) {
		WebdavDirectory webdavDirectory = webdavDirectoryDao.findOneByUser(userDetailsVO.getIdUser());
		if (webdavDirectory == null) {
			return null;
		}

		WebdavDirectoryVO webdavDirectoryVO = new WebdavDirectoryVO();
		webdavDirectoryVO.setIdDirectory(webdavDirectory.getIdDirectory());
		webdavDirectoryVO.setIdUser(webdavDirectory.getIdUser());
		webdavDirectoryVO.setFilePath(webdavDirectory.getFilePath());
		webdavDirectoryVO.setFileName(webdavDirectory.getFileName());

		return webdavDirectoryVO;
	}

	public WebdavDirectoryVO createOne(WebdavDirectoryVO webdavDirectoryVO) {
		WebdavDirectory webdavDirectory = new WebdavDirectory();
		webdavDirectory.setIdUser(webdavDirectoryVO.getIdUser());
		webdavDirectory.setFilePath(webdavDirectoryVO.getFilePath());
		webdavDirectory.setFileName(webdavDirectoryVO.getFileName());
		webdavDirectory = webdavDirectoryDao.save(webdavDirectory);

		webdavDirectoryVO = new WebdavDirectoryVO();
		webdavDirectoryVO.setIdDirectory(webdavDirectory.getIdDirectory());
		webdavDirectoryVO.setIdUser(webdavDirectory.getIdUser());
		webdavDirectoryVO.setFilePath(webdavDirectory.getFilePath());
		webdavDirectoryVO.setFileName(webdavDirectory.getFileName());

		return webdavDirectoryVO;
	}

	public WebdavDirectoryVO updateOne(WebdavDirectoryVO webdavDirectoryVO) {
		WebdavDirectory webdavDirectory = webdavDirectoryDao.findOneById(webdavDirectoryVO.getIdDirectory());
		if (webdavDirectory == null) {
			throw new ServiceException("WebdavDirectory [IdDirectory: " + webdavDirectoryVO.getIdDirectory() + "] not exists");
		}

		webdavDirectory.setIdUser(webdavDirectoryVO.getIdUser());
		webdavDirectory.setFilePath(webdavDirectoryVO.getFilePath());
		webdavDirectory.setFileName(webdavDirectoryVO.getFileName());
		webdavDirectory = webdavDirectoryDao.save(webdavDirectory);
		
		webdavDirectoryVO = new WebdavDirectoryVO();
		webdavDirectoryVO.setIdDirectory(webdavDirectory.getIdDirectory());
		webdavDirectoryVO.setIdUser(webdavDirectory.getIdUser());
		webdavDirectoryVO.setFilePath(webdavDirectory.getFilePath());
		webdavDirectoryVO.setFileName(webdavDirectory.getFileName());

		return webdavDirectoryVO;
	}

	public void deleteOne(WebdavDirectoryVO webdavDirectoryVO) {
		WebdavDirectory webdavDirectory = webdavDirectoryDao.findOneById(webdavDirectoryVO.getIdDirectory());
		if (webdavDirectory == null) {
			throw new ServiceException("WebdavDirectory [IdDirectory: " + webdavDirectoryVO.getIdDirectory() + "] not exists");
		}
		
		webdavDirectoryDao.delete(webdavDirectory);
	}

}
