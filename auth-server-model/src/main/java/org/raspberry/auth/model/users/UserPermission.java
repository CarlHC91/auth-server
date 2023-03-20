package org.raspberry.auth.model.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserPermissionPK.class)
@Table(name = "USER_PERMISSION")
public class UserPermission {

	@Id
	@Column(name = "ID_USER")
	private Long idUser;

	@Id
	@Column(name = "ID_PERMISSION")
	private Long idPermission;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
