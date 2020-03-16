package com.hieunv.converter;

import org.springframework.stereotype.Component;

import com.hieunv.dto.UserDTO;
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
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setFullName(entity.getFullName());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}
