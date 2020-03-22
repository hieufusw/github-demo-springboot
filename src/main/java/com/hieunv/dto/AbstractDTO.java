package com.hieunv.dto;

import java.util.Date;

public class AbstractDTO<T> {
private Long id;// khong can ham set
	
	private String createdBy;
	
	private Date createdDate;
	
	private String modifieddBy;
	
	private Date modifiedDate;
		
//	private List<T> listResult = new ArrayList<>();
//
//	public List<T> getListResult() {
//		return listResult;
//	}
//
//	public void setListResult(List<T> listResult) {
//		this.listResult = listResult;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	
	
}
