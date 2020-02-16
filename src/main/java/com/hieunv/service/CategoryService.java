package com.hieunv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieunv.entity.CategoryEntity;
import com.hieunv.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryEntity> getAll(){
		return (List<CategoryEntity>) categoryRepository.findAll();	
	}
}
