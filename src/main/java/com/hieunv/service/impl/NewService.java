package com.hieunv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hieunv.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hieunv.common.converter.NewConverter;
import com.hieunv.common.dto.NewDTO;
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
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null)// dang update
		{
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId()); //đầu tiên get oldNew lên
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);// roi sau do converter sang new mới
		} else {
			newEntity = newConverter.toEntity(newDTO); // conver nguyen ban
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public List<NewDTO> findByTitle(String title) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findByTitle(title);
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}


	@Override
	public List<NewDTO> findByTitleAndContent(String title, String content) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findByTitleAndContent(title,content);
		for(NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}
}
