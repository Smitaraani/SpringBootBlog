package com.SpringbootFacebookApplication.SpringbootFacebookApplication.service;

import java.util.List;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.UserDto;

public interface UserService {
	
	//craete user
	
	UserDto craeteuser(UserDto userdto);
	
	
	//fetch all user
	
	List<UserDto>getAllUser();
	
	
	//fetch by id
	
	UserDto getById(int id);//exception handle
	
	
	
	//update user
	
	UserDto updateUser(UserDto userdto,int id);
	
	
	
	
	//delete user
	
	void delteUser(int id);
	
	
	
	

}
