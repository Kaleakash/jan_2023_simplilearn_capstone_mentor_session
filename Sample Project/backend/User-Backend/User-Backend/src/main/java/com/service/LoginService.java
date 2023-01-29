package com.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.entity.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("after memory created");
		Login ll =new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setPassword("admin@123");
		ll.setTypeofuser("admin");
		
		Optional<Login> res = loginRepository.findById("admin@gmail.com");
		if(!res.isPresent()) {
			loginRepository.save(ll);
		}
	}
	
	
	public String signIn(Login ll) {
		Optional<Login> res = loginRepository.findById(ll.getEmailid());
		if(res.isPresent()) {
			Login dbLogin = res.get();
			if(dbLogin.getPassword().equals(ll.getPassword())) {
						if(dbLogin.getTypeofuser().equals("admin")){
							return "Admin login successfully";
						}else {
							return "User login successfully";
						}
			}else {
				return "Invalid password";
			}
		}else {
			return "Invalid emailid";
		}
	}
	
	
	public String signUp(Login ll) {
		if(ll.getTypeofuser().equalsIgnoreCase("admin")) {
			return "You can't create admin account";
		}else {
			Optional<Login> res = loginRepository.findById(ll.getEmailid());
			if(res.isPresent()) {
				return "Account already exits";
			}else {
				loginRepository.save(ll);
				return "Account created";
			}
		}
	}
}