package org.raspberry.auth.dto.model.roles;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDetailsDTO {

	@JsonProperty("id_role")
	private Long idRole;

	@JsonProperty("name")
	private String name;

	@JsonProperty("create_date")
	private Date createDate;

	@JsonProperty("update_date")
	private Date updateDate;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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