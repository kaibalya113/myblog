package com.myblog.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myblog.main.model.Post;
import com.myblog.main.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	public static Logger log = LoggerFactory.getLogger(PostController.class.getName());
	@Autowired
	private PostService postService;
	
//	@GetMapping(value="allposts", produces = "application/Json")
//	public List<Post> getAllPost(){
//
//		return null;
//	}
	
	
	@PostMapping("/create")
	public ResponseEntity<String> createPost(@RequestBody Post post) {
		log.info("Entered POST : "+ post);
		postService.createPost(post);
		return  ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
	}
	@GetMapping("/allposts")
	public ResponseEntity<List<Post>> getAllPost(){
		List<Post> list = postService.getllAllPost();
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}

	@GetMapping
	public ResponseEntity<List<Post>> getPostsByCategory(){
		List<Post> list = postService.getllAllPost();
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
}
