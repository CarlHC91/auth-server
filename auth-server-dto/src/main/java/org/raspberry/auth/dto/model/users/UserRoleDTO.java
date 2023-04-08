package org.raspberry.auth.dto.model.users;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRoleDTO {

	@JsonProperty("id_user")
	private Long idUser;

	@JsonProperty("id_role")
	private Long idRole;

	@JsonProperty("create_date")
	private Date createDate;

	@JsonProperty("update_date")
	private Date updateDate;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
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