package com.myblog.main.serviceImpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import com.myblog.main.config.UniqueNumber;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.main.config.SecurityConfiguration;
import com.myblog.main.custom.exception.DataNotFoundException;
import com.myblog.main.dao.UserDao;
import com.myblog.main.model.Login;
import com.myblog.main.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	public static Logger log = LoggerFactory.getLogger(UserServiceImpl.class.getName());
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private PasswordEncoder passEncoder;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Logic to get the user from database
		Login login = userDao.finByEmail(username);
		if (login == null) {
            throw new InternalAuthenticationServiceException("Not Found..");
        }
		return new User(login.getEmailId(), login.getPassword(), new ArrayList<>());
		//return new Login(1, "krishna@gmail.com", "password", "USER", new Date(), true, "fj27568");
	}
	
	
	@Override
	public Login signIn(Login login) {
		
		UserDetails userDetails = loadUserByUsername(login.getEmailId());
		boolean isMatch = passEncoder.matches(login.getPassword(), userDetails.getPassword());
		if(isMatch) {
			return new Login(userDetails.getUsername(), userDetails.getPassword());
		}else {
			throw new InternalAuthenticationServiceException("Password not matched..");
		}
	}

	@Override
	public boolean registerUser(Login login) {

		Login isRegister = loginDao.findByEmailId(login.getEmailId());
		if(isRegister.getEmailId() ==null){
			String pass = passEncoder.encode(login.getPassword());
			login.setActive(false);
			login.setLoginTime(new Date());
			login.setUniqueNo(UniqueNumber.uniqueNoGenerate());
			login.setPassword(pass);
			login.setRole("USER");
			loginDao.save(login);
			return true;
		}
		return false;

		
	}

	@Override
	public Login getById(Integer id) {
		Optional<Login> login =  loginDao.findById(id);
		log.info("user ::"+ login);
		if(login.isPresent()) {
			return login.get();
		}
		throw new DataNotFoundException("User Not Found...");
	}

	@Override
	public boolean createUserProfile(com.myblog.main.model.User user) {
		log.info("user :"+ user.toString());
		com.myblog.main.model.User isPresent = userDao.findByEmail(user.getEmailId());
		log.info("isPresent : "+ isPresent);
		if(isPresent == null){
			userDao.save(user);
			return true;
		}
		return false;
	}


}
