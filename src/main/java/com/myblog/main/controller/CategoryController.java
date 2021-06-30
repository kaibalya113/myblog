package com.myblog.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myblog.main.model.Category;
import com.myblog.main.service.CategoryService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CategoryController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CategoryController.class);


	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping(value= "/dashboardata" , headers="Accept=*/*", produces = "application/json")
	public ResponseEntity<List<Category>> getAllCategory() {		
		List<Category> list = categoryService.getAll();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
	}
	
	
}
