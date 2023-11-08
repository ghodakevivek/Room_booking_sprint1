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

import com.example.roombooking.entity.User;
import com.example.roombooking.model.UserDTO;
import com.example.roombooking.service.UserService;
import com.example.roombooking.util.UserConverter;
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter userConverter;
	
	
	// Method for creating the user
	@PostMapping("/create")
	public ResponseEntity <UserDTO> createUser (@Valid @RequestBody UserDTO userDto)
	{
		final User user=userConverter.convertToUserEntity(userDto);
		return new ResponseEntity<UserDTO>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all users
	@GetMapping("/getAll")
	public List<UserDTO> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	
	// method for retrieving user using Id
	@GetMapping("/get/{id}")
	public UserDTO getUserById(@PathVariable int id)
	{
		return userService.getUserById();
	}
	
	
	// Method for updating the user
	@PutMapping("/update/{id}")
	UserDTO updateUser(@Valid @PathVariable int id, @RequestBody UserDTO userDto)
	{
		final User user=userConverter.convertToUserEntity(userDto);
		return userService.updateUser(id, user);
				
	}
	
	
	// Method for deleting the user using id
	@DeleteMapping("/delete/{id}")
	String deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}
}
