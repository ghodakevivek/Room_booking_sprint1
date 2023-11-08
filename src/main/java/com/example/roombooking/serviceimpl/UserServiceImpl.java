package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.UserRepository;
import com.example.roombooking.entity.User;
import com.example.roombooking.model.UserDTO;
import com.example.roombooking.service.UserService;
import com.example.roombooking.util.UserConverter;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	
	// create user method
	@Override
	public UserDTO createUser(User user)
	{
		User u=userRepository.save(user);
		return userConverter.convertToUserDTO(u);
	}
	
	
	// Retrieve all users
	@Override
	public List<UserDTO> getAllUsers(){
		List<User> user=userRepository.findAll();
		
		//list of type DTO
		List<UserDTO> dtoList=new ArrayList<>();
		for(User u: user)
		{
			dtoList.add(userConverter.convertToUserDTO(u));
		}
		return dtoList;
	}
	
	
	// Retrieve user by id
	@Override
	public UserDTO getUserById(int id) {
		User u=userRepository.findByUserId(id);
		return userConverter.convertToUserDTO(u);
	}
	
	
	// Update user by id
	@Override
	public UserDTO updateUser(int id, User user) {
		User u=userRepository.findByUserId(id);
		
		u.setUserFirstName(user.getUserFirstName());
		u.setUserLastName(user.getUserLastName());
		u.setUserAadhar(user.getUserAadhar());
		u.setUserAge(user.getUserAge());
		u.setUserCity(user.getUserCity());
		u.setUserMobile(user.getUserMobile());
		u.setUserUserName(user.getUserUserName());
		u.setUserPassword(user.getUserPassword());
		u.setUserEmail(user.getUserEmail());
		
		
		User ur=userRepository.save(u);
		return userConverter.convertToUserDTO(ur);
	}
	
	
	// Delete user by id
	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User got deleted successFully";
	}


	@Override
	public UserDTO getUserById() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
