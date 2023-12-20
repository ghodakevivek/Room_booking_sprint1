package com.example.roombooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.roombooking.config.LoginMesage;
import com.example.roombooking.model.ALoginDTO;
import com.example.roombooking.service.AdminService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;
	

	

	
	
	
	// Method for login
	 @PostMapping("/login/admin")
	    public ResponseEntity<?> loginUser(@RequestBody ALoginDTO loginDTO)
	    {
	    	LoginMesage loginResponse = adminService.loginAdmin(loginDTO);
	        return ResponseEntity.ok(loginResponse);
	    }
	
}
