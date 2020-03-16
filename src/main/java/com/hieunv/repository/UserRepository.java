package com.hieunv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieunv.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
