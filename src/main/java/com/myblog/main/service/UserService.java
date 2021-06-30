package com.myblog.main.service;

import java.util.ArrayList;

import com.myblog.main.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myblog.main.model.Login;

public interface UserService extends UserDetailsService{

	public boolean registerUser(Login login);
	public Login signIn(Login login);
	public Login getById(Integer id);

	boolean createUserProfile(User user);
}
