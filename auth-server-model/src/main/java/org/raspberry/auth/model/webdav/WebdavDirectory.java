package org.raspberry.auth.model.webdav;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBDAV_DIRECTORY")
public class WebdavDirectory {

	@Id
	@Column(name = "ID_DIRECTORY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDirectory;

	@Column(name = "ID_USER")
	private Long idUser;

	@Column(name = "FILE_PATH")
	private String filePath;

	@Column(name = "FILE_NAME")
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
