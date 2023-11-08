package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.UserLogin;
import com.example.roombooking.model.UserLoginDTO;

public interface UserLoginService {

	public UserLoginDTO createUserLogin(UserLogin userLogin);
	public List<UserLoginDTO> getAllUserLogins();
	public UserLoginDTO getUserLoginById(int id);
	public UserLoginDTO updateUserLogin(int id, UserLogin userLogin);
	public String deleteUserLogin(int id);
	public UserLoginDTO getUserLoginById();

}
