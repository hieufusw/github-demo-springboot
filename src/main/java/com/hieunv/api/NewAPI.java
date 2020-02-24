package com.hieunv.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieunv.api.output.NewOutput;
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

//	@PostMapping(value = "/new")
//	public NewDTO createNew(@RequestBody NewDTO model) {
//		return newService.save(model);
//	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<CategoryEntity> getCategories() {
		return iCategoryService.getAll();
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@RequestMapping(value = "/new/{id}", method = RequestMethod.PUT)
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@RequestMapping(value = "/new", method = RequestMethod.DELETE)
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
	
	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam("page") int page,
							 @RequestParam("limit") int limit) {
		NewOutput result = new NewOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page-1, limit);
		result.setListResult(newService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit)); 
		return result;
	}

//	@DeleteMapping(value = "/new")
//	public void deleteNew(@RequestBody long[] ids) {
//
//	}
}