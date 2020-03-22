package com.hieunv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
