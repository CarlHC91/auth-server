package org.raspberry.auth.pojos.operations.webdavdirectory;

import org.raspberry.auth.pojos.entities.webdav.WebdavDirectoryVO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteOne_IN {

	@JsonProperty("webdav_directory")
	private WebdavDirectoryVO webdavDirectory;

	public WebdavDirectoryVO getWebdavDirectory() {
		return webdavDirectory;
	}

	public void setWebdavDirectory(WebdavDirectoryVO webdavDirectory) {
		this.webdavDirectory = webdavDirectory;
	}

}
