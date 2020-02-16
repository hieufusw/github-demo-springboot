package com.hieunv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunv.converter.NewConverter;
import com.hieunv.dto.NewDTO;
import com.hieunv.entity.CategoryEntity;
import com.hieunv.entity.NewEntity;
import com.hieunv.repository.CategoryRepository;
import com.hieunv.repository.NewRepository;

@Service
public class NewService implements INewService {
	@Autowired
	private NewRepository newRepository;

	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private NewConverter newConverter;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		NewEntity newEntity = newConverter.toEntity(newDTO);
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}
}
