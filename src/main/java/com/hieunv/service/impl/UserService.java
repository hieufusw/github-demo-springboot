package com.hieunv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hieunv.converter.UserConverter;
import com.hieunv.dto.UserDTO;
import com.hieunv.entity.RoleEntity;
import com.hieunv.entity.UserEntity;
import com.hieunv.repository.RoleRepository;
import com.hieunv.repository.UserRepository;
import com.hieunv.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.toEntity(userDTO);
		userEntity.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		List<RoleEntity> list = new ArrayList<>();
		list.add(roleRepository.findOneByCode(userDTO.getRoleCode()));
		userEntity.setRoles(list);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

}
