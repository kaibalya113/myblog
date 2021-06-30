package com.myblog.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.main.model.Post;

public interface PostDao extends JpaRepository<Post, Integer>{
	
}
