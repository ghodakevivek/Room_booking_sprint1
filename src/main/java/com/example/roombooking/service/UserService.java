package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.User;
import com.example.roombooking.model.UserDTO;
import com.example.roombooking.model.LoginDTO;
import com.example.roombooking.config.LoginMesage;

public interface UserService {

	public UserDTO createUser(User user);
	public List<UserDTO> getAllUsers();
	public UserDTO getUserById(int id);
	public UserDTO updateUser(int id, User user);
	public String deleteUser(int id);
	public UserDTO getUserById();
	
	public String addUser(UserDTO userDTO);
	public LoginMesage  loginUser(LoginDTO loginDTO);
	 
	
}
