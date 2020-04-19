package com.hieunv.service.impl;

import java.util.List;

import com.hieunv.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunv.entity.CategoryEntity;
import com.hieunv.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryEntity> findAll() {
		List<CategoryEntity> category = categoryRepository.findAll();
		return category;
	}
}
