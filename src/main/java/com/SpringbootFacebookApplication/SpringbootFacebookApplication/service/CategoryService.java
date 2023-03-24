package com.SpringbootFacebookApplication.SpringbootFacebookApplication.service;

import java.util.List;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.CatagoryDto;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;

public interface CategoryService {

	
	
//craete category
	
	CatagoryDto craetecategory(CatagoryDto userdto);
	
	
	//fetch all user
	
	List<CatagoryDto>getAllCatagory();
	
	
	//fetch by id
	
	CatagoryDto getById(int catagoryId);//exception handle
	
	
	
	//update user
	
	CatagoryDto updateCatagory(CatagoryDto catagorydto,int catagoryId);
	
	
	
	
	//delete user
	
	void delteCatagory(int catagoryId);
	
	
	
	
}
