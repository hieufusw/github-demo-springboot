package com.hieunv.service;

import com.hieunv.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
//	NewDTO update(NewDTO newDTO);
	void delete(long[] ids);
}
