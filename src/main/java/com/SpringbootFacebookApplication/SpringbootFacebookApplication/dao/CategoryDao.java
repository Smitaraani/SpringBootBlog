package com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
