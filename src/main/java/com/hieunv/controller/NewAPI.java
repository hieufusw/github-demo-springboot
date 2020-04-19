package com.hieunv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieunv.controller.output.NewOutput;
import com.hieunv.common.dto.NewDTO;
import com.hieunv.entity.CategoryEntity;
import com.hieunv.service.ICategoryService;
import com.hieunv.service.INewService;

@RestController // = @Controller + @ResponseBody
public class NewAPI {

//	
//	viết API add new user
//	user có các option: id, userName, password,..
//	trước khi thêm user vào DB phải check yêu cầu
//	PassWord phải có 1 chữ cái viết hoa, có kí tự là số, nhiều hơn 6 kí tự.
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private INewService newService;

//	@RequestMapping(value = "/category", method = RequestMethod.GET)
//	public List<CategoryEntity> getCategories() {
//		return iCategoryService.getAll();
//	}
	
//@GetMapping = @RequestMapping + method
	@GetMapping(value = "/category")
	public List<CategoryEntity> getCategories() {
		return categoryService.findAll();
	}
	
	@PostMapping(value = "/new/searchTitle")
	public List<NewDTO> searchNews(@RequestBody NewDTO model) {
		return newService.findByTitle(model.getTitle());
	}
	@PostMapping(value = "/new/searchMUL")
	public List<NewDTO> searchMUL(@RequestBody NewDTO model) {
		return newService.findByTitleAndContent(model.getTitle(), model.getContent());
	}
	

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}

	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page, //mac dinh la true=> phai chuyen vè false(co cũng đc, k co cũng dc)
			@RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput result = new NewOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}
		return result;
	}

}