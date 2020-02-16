package com.hieunv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieunv.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}
