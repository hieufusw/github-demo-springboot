package com.hieunv.service;

import com.hieunv.common.dto.UserDTO;


public interface IUserService {
	UserDTO save(UserDTO userDTO);
	void delete(long[] ids);
}
