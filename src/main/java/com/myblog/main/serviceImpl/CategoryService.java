package com.myblog.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.main.dao.CategoryDao;
import com.myblog.main.model.Category;

@Service
public class CategoryService implements com.myblog.main.service.CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> getAll() {
		List<Category> list = categoryDao.findAll();
		
		
		return list;
	}

}
