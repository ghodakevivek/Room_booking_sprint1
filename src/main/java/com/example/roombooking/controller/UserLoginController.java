package com.example.roombooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roombooking.entity.UserLogin;
import com.example.roombooking.model.UserLoginDTO;
import com.example.roombooking.service.UserLoginService;
import com.example.roombooking.util.UserLoginConverter;

@RestController
@RequestMapping("/api/userLogin")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserLoginConverter userLoginConverter;
	
	
	// Method for creating the userLogin
	@PostMapping("/create")
	public ResponseEntity <UserLoginDTO> createUserLogin (@Valid @RequestBody UserLoginDTO userLoginDto)
	{
		final UserLogin userLogin=userLoginConverter.convertToUserLoginEntity(userLoginDto);
		return new ResponseEntity<UserLoginDTO>(userLoginService.createUserLogin(userLogin),HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all userLogins
	@GetMapping("/getAll")
	public List<UserLoginDTO> getAllUserLogins()
	{
		return userLoginService.getAllUserLogins();
	}
	
	
	// method for retrieving userLogins using Id
	@GetMapping("/get/{id}")
	public UserLoginDTO getUserLoginById(@PathVariable int id)
	{
		return userLoginService.getUserLoginById(id);
	}
	
	
	// Method for updating the userLogin
	@PutMapping("/update/{id}")
	public UserLoginDTO updateUserLogin(@Valid @PathVariable int id, @RequestBody UserLoginDTO userLoginDto)
	{
		final UserLogin userLogin=userLoginConverter.convertToUserLoginEntity(userLoginDto);
		return userLoginService.updateUserLogin(id, userLogin);
				
	}
	
	
	// Method for deleting the userLogin using id
	@DeleteMapping("/delete/{id}")
	public String deleteUserLogin(@PathVariable int id)
	{
		return userLoginService.deleteUserLogin(id);
	}
}
