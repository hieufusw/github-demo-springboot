package com.hieunv.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	@Id//not null - primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// tu tang gtri id
	private Long id;// khong can ham set
	
	@Column
	@CreatedBy
	private String createdBy;//lây tu user khi login, lay user là AuditorAwareImpl trong JpaAuditingConfig(làm tu dong cho 4 cái luôn)
	
	@Column
	@CreatedDate
	private Date createdDate;
	
	@Column
	@LastModifiedBy
	private String modifieddBy;
	
	@Column
	@LastModifiedDate
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
