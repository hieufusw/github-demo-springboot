package com.hieunv.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hieunv.common.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
//	NewDTO update(NewDTO newDTO);
	void delete(long[] ids);
	List<NewDTO> findByTitle(String title);
	List<NewDTO> findByTitleAndContent(String title, String content);
	List<NewDTO> findAll(Pageable pageable);//phân trang
	List<NewDTO> findAll();
	int totalItem();
}


/*
 * Phan trang
 * 1. gui data ve client: input - truyền từ client về
 * -page
 * -limit
 * 2. data trả ve tu server cho client: output 
 * -totalPage
 * -page
 * -list<data>: NewDTO - du lieu
 * 
 * De phân trang: Login phân trang
 * - trên 1 trang se có bnh item
 * limit: so item tren 1 page
 * totalPage: tong so page
 * totalItem: tong so item dc  tra ra
 * page: là sô trang hien tại
 */
 