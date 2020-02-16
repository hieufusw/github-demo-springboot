package com.hieunv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	@Id//not null - primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// tu tang gtri id
	private Long id;// khong can ham set
	
	@Column
	private String createdBy;
	
	@Column
	private Date createdDate;
	
	@Column
	private String modifieddBy;
	
	@Column
	private Date modifiedDate;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifieddBy() {
		return modifieddBy;
	}
	public void setModifieddBy(String modifieddBy) {
		this.modifieddBy = modifieddBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Long getId() {
		return id;
	}
	
}
