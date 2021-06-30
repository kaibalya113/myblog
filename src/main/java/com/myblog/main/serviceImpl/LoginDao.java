package com.myblog.main.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.main.model.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginDao extends JpaRepository<Login, Integer>{

    @Query("Select l from Login l where l.emailId=:email")
    Login findByEmailId(@Param("email") String emailId);
}
