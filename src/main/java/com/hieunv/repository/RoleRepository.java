package com.hieunv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieunv.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findOneByCode(String code);
}
