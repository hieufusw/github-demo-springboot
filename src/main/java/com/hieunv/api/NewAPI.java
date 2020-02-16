package com.hieunv.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hieunv.dto.NewDTO;
import com.hieunv.entity.CategoryEntity;
import com.hieunv.service.ICategoryService;
import com.hieunv.service.INewService;

@RestController
public class NewAPI {

	@Autowired
	ICategoryService iCategoryService;
	
	@Autowired
	private INewService newService;

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<CategoryEntity> getCategories() {
		return iCategoryService.getAll();
	}

	@PutMapping(value = "/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return model;
	}

	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {

	}
}