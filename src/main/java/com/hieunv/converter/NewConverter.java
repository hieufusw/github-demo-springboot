package com.hieunv.converter;

import org.springframework.stereotype.Component;
//convert du lieu tu NEwDTO => ENtity

import com.hieunv.dto.NewDTO;
import com.hieunv.entity.NewEntity;
@Component //tuong duong voi @Service orr @Repository
public class NewConverter {
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
	
	//convert tu dot->entity thif phai convert ngc lai de tra ve API
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		return dto;
	}
}


