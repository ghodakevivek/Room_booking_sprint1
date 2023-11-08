package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.User;
import com.example.roombooking.model.UserDTO;

public interface UserService {

	public UserDTO createUser(User user);
	public List<UserDTO> getAllUsers();
	public UserDTO getUserById(int id);
	public UserDTO updateUser(int id, User user);
	public String deleteUser(int id);
	public UserDTO getUserById();
}
