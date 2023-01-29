package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Login;
import com.service.LoginService;

@RestController
@RequestMapping("login")
@CrossOrigin			// To enable cors policy 
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	
	// http://localhost:9090/login/signIn  then pass data in json format as emailid,password typeofuser
	@PostMapping(value = "signIn",consumes =  MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login ll) {
			if(!ll.getEmailid().contains("@")) {
				return "EmailId must be contains @";
			}else {
				return loginService.signIn(ll);
			}
		
		//
	}
	
	//  http://localhost:9090/login/signUp
	@PostMapping(value = "signUp",consumes =  MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Login ll) {
		return loginService.signUp(ll);
	}
	
	
	// http://localhost:9090/login/error 
	public ResponseEntity<Login> myResponse() {
		return ResponseEntity.status(200).build();
	}
}
