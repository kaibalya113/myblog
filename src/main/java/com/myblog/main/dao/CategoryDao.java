package com.myblog.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.main.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

}
