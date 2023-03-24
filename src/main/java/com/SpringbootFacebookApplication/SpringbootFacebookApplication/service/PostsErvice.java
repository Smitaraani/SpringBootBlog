package com.SpringbootFacebookApplication.SpringbootFacebookApplication.service;

import java.util.List;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Post;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload.PostDto;

public interface PostsErvice {
	
	
	PostDto createpost(PostDto postDto, Integer userId, Integer categoryId);
	public List<Post>getuserid(int userid);
	public  List<Post>getCatid(int catid);
	//register post 
	
	public PostDto createPost(PostDto postdto);
	
	
	//findall
	
	public List<PostDto>getAllpost();
	
	
	
	
	public PostDto findbyPostid(int postid);
	
	
	
	
	public PostDto updatepost(PostDto postDto,int postid);
	
	
	
	public void postdelte(int postid);

}
