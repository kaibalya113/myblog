package com.myblog.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myblog.main.dao.PostDao;
import com.myblog.main.model.Category;
import com.myblog.main.model.Post;
import com.myblog.main.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public Post createPost(Post post) {
		postDao.save(post);
		Integer postId = post.getId();
		//Integer categoryId = post.getCategoryList().
		for (Category c : post.getCategoryList()) {
			Integer categoryId = c.getcId();
			postDao.insertCategory(postId, categoryId);
		}
		return null;
	}

	@Override
	public List<Post> getllAllPost() {
		List<Post> list = postDao.findAll();
		return list;
	}

}
