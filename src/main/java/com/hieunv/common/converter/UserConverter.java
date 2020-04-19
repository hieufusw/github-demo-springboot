package com.hieunv.common.converter;

import org.springframework.stereotype.Component;

import com.hieunv.common.dto.UserDTO;
import com.hieunv.entity.UserEntity;

@Component
public class UserConverter {
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullName());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setFullName(entity.getFullName());
		dto.setStatus(entity.getStatus());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setModifieddBy(entity.getModifieddBy());
		dto.setModifiedDate(entity.getCreatedDate());
		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto, UserEntity entity) {
		entity.setUserName(dto.getUserName());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullName());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
}
