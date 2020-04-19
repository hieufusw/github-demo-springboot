package com.hieunv.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

//user va role => many to many @ManyToMany =>> 1 bang trung gian user_role => user vs user_role là 1-n / role vs user_role la 1-n

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "username")
	@NotBlank(message = "User Name is mandatory")
	private String userName;
	@Column
	private String password;
	@NotBlank(message = "Fullname is mandatory")
	@Column(name = "fullname")
	private String fullName;
	@Column
	private Integer status;
	@Column(name = "number_login_fail")
	private Long numberLoginFail;

	public Long getNumberLoginFail() {
		return numberLoginFail;
	}

	public void setNumberLoginFail(Long numberLoginFail) {
		this.numberLoginFail = numberLoginFail;
	}

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private List<RoleEntity> roles = new ArrayList<>();
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roleEntity) {
		this.roles = roleEntity;
	}

}
