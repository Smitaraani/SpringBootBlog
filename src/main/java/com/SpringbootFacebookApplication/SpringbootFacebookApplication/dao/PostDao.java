package com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Category;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Post;
import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;

public interface PostDao extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

}
