package com.myblog.main.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.main.model.Login;
import com.myblog.main.model.User;
import com.myblog.main.service.UserService;

@RestController
@RequestMapping("/user")
//@Slf4j
public class UserController {
	public static Logger log = LoggerFactory.getLogger(UserController.class.getName());
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody Login login){
		
		boolean isRegister = userService.registerUser(login);
		return (isRegister)? ResponseEntity.status(HttpStatus.CREATED).body("SUCCESSFULLY CREATED...")
			: ResponseEntity.status(HttpStatus.CONFLICT).body("Email Id already Present...");

	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Login login){
		
		userService.signIn(login);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("USER LOGGED IN...");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Login> loginUser(@PathVariable Integer id){
		log.info("callng getby id : "+ id);
		Login login = userService.getById(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}

	@PostMapping("/createProfle")
	public ResponseEntity<String> crateProfile(@RequestBody User user){
		// for forntend we are taking email if after he login sucessfully
		boolean isCreated = userService.createUserProfile(user);
		return (isCreated)? ResponseEntity.status(HttpStatus.CREATED).body("User Created..."):
				ResponseEntity.status(HttpStatus.CONFLICT).body("User not Created...");
	}
}
