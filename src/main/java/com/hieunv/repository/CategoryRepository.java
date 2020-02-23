package com.hieunv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieunv.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
//có ham có săn r
	CategoryEntity findOneByCode(String code);
}
