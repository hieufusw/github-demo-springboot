package com.hieunv.service;

import com.hieunv.common.dto.UserDTO;
import com.hieunv.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;


public interface IUserService {
	UserDTO save(UserDTO userDTO);
	void delete(long[] ids);
	UserEntity findByUserName(String userName);
	//void updateNumberTimesLoginFail(HttpServletRequest request, UserEntity user, Long numberLoginFail);
}
