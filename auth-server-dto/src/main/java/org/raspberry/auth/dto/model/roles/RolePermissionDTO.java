package org.raspberry.auth.dto.model.roles;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RolePermissionDTO {

	@JsonProperty("id_permission")
	private Long idPermission;

	@JsonProperty("id_role")
	private Long idRole;

	@JsonProperty("service_path")
	private String servicePath;

	@JsonProperty("create_date")
	private Date createDate;

	@JsonProperty("update_date")
	private Date updateDate;

	public Long getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getServicePath() {
		return servicePath;
	}

	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
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