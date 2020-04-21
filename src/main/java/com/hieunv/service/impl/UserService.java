package com.hieunv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hieunv.common.converter.UserConverter;
import com.hieunv.common.dto.UserDTO;
import com.hieunv.entity.RoleEntity;
import com.hieunv.entity.UserEntity;
import com.hieunv.repository.RoleRepository;
import com.hieunv.repository.UserRepository;
import com.hieunv.service.IUserService;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService implements IUserService {

	
	//^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if (userDTO.getId() != null) {
			UserEntity oldUser = userRepository.findOne(userDTO.getId());
			userEntity = userConverter.toEntity(userDTO, oldUser);

		} else {
			userEntity = userConverter.toEntity(userDTO);
		}
		userEntity.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		List<RoleEntity> list = new ArrayList<>();
		list.add(roleRepository.findOneByCode(userDTO.getRoleCode()));
		userEntity.setRoles(list);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			userRepository.delete(item);
		}
		
	}

}
