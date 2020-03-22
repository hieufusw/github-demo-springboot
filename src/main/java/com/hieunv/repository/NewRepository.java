package com.hieunv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieunv.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

	List<NewEntity> findByTitle(String title);
	
	List<NewEntity> findByTitleAndContent(String title, String content);
}
