package com.hieunv.controller;

import com.hieunv.common.dto.WebLoginResponse;
import com.hieunv.common.exception.BusinessException;
import com.hieunv.common.request.LoginRequest;
import com.hieunv.service.IAuthenticationBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hieunv.common.dto.UserDTO;
import com.hieunv.service.IUserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserAPI {

	@Autowired
	private IUserService userSerive;
	@Autowired
	private IAuthenticationBusiness iAuthenticationBusiness;
	
	@PostMapping(value = "/user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return userSerive.save(model);
	}
	
	@PostMapping(value = "/user/{id}")
	public UserDTO updateUser(@RequestBody UserDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return userSerive.save(model);
	}
	
	@DeleteMapping(value = "/user")
	public void deleteUser(@RequestBody long[] ids) {
		userSerive.delete(ids);
	}

	@GetMapping(value = "/login")
	public WebLoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) throws BusinessException {
		return iAuthenticationBusiness.webAuthen(loginRequest,request);
	}
}
