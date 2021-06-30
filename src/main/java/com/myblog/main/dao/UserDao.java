package com.myblog.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myblog.main.model.Login;
import com.myblog.main.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	@Query("select b from Login b where b.emailId=:username")
	Login finByEmail(@Param("username") String username);

	@Query("Select u from User u where u.emailId=:email")
	User findByEmail(@Param("email") String emailId);
	
}
