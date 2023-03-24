package com.SpringbootFacebookApplication.SpringbootFacebookApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringbootFacebookApplication.SpringbootFacebookApplication.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {

}

