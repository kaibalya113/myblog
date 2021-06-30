package com.myblog.main.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myblog.main.model.Post;

import java.util.List;


public interface PostService {
	public Post createPost(Post post);
	public List<Post> getllAllPost();
}
