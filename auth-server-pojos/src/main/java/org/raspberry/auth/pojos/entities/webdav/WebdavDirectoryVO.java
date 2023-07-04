package org.raspberry.auth.pojos.entities.webdav;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebdavDirectoryVO {

	@JsonProperty("id_directory")
	private Long idDirectory;

	@JsonProperty("id_user")
	private Long idUser;

	@JsonProperty("file_path")
	private String filePath;

	@JsonProperty("file_name")
	private String fileName;

	public Long getIdDirectory() {
		return idDirectory;
	}

	public void setIdDirectory(Long idDirectory) {
		this.idDirectory = idDirectory;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}