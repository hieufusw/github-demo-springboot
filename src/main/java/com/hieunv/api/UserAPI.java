package com.hieunv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hieunv.dto.UserDTO;
import com.hieunv.service.IUserService;

@RestController
public class UserAPI {

	@Autowired
	private IUserService userSerive;
	
	@PostMapping(value = "/user")
	public UserDTO createNew(@RequestBody UserDTO model) {
		return userSerive.save(model);
	}

}
