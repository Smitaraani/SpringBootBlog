package com.SpringbootFacebookApplication.SpringbootFacebookApplication.payload;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Category;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;

public class PostDto {

	private int postId;

	private String postTitle;

	private String content;

	private String imageName;

	private LocalDateTime localDateTime;
	
	
	private User userDto;
	
	
	private Category catagoryDto;


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getPostTitle() {
		return postTitle;
	}


	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	public User getUserDto() {
		return userDto;
	}


	public void setUserDto(User userDto) {
		this.userDto = userDto;
	}


	public Category getCatagoryDto() {
		return catagoryDto;
	}


	public void setCatagoryDto(Category catagoryDto) {
		this.catagoryDto = catagoryDto;
	}


	public PostDto(int postId, String postTitle, String content, String imageName, LocalDateTime localDateTime,
			User userDto, Category catagoryDto) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.content = content;
		this.imageName = imageName;
		this.localDateTime = localDateTime;
		this.userDto = userDto;
		this.catagoryDto = catagoryDto;
	}


	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "PostDto [postId=" + postId + ", postTitle=" + postTitle + ", content=" + content + ", imageName="
				+ imageName + ", localDateTime=" + localDateTime + ", userDto=" + userDto + ", catagoryDto="
				+ catagoryDto + "]";
	}
	
	
	
	

}
