package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.UserLoginRepository;
import com.example.roombooking.entity.UserLogin;
import com.example.roombooking.model.UserLoginDTO;
import com.example.roombooking.service.UserLoginService;
import com.example.roombooking.util.UserLoginConverter;
@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private UserLoginConverter userLoginConverter;
	
	
	// create userLogin method
	@Override
	public UserLoginDTO createUserLogin(UserLogin userLogin)
	{
		UserLogin uLogin=userLoginRepository.save(userLogin);
		return userLoginConverter.convertToUserLoginDTO(uLogin);
	}
	
	
	// Retrieve all userLogins
	@Override
	public List<UserLoginDTO> getAllUserLogins(){
		List<UserLogin> userLogin=userLoginRepository.findAll();
		
		//list of type DTO
		List<UserLoginDTO> dtoList=new ArrayList<>();
		for(UserLogin ul: userLogin)
		{
			dtoList.add(userLoginConverter.convertToUserLoginDTO(ul));
		}
		return dtoList;
	}
	
	
	// Retrieve userLogin by id
	@Override
	public UserLoginDTO getUserLoginById(int id) {
		UserLogin ul=userLoginRepository.findByUserLoginId(id);
		return userLoginConverter.convertToUserLoginDTO(ul);
	}
	
	
	// Update userLogin by id
	@Override
	public UserLoginDTO updateUserLogin(int id, UserLogin userLogin) {
		UserLogin ul=userLoginRepository.findByUserLoginId(id);
		
		ul.setUserUserName(userLogin.getUserUserName());
		ul.setUserPassword(userLogin.getUserPassword());
		
		UserLogin uLogin=userLoginRepository.save(ul);
		return userLoginConverter.convertToUserLoginDTO(uLogin);
	}
	
	
	// Delete userLogin by id
	@Override
	public String deleteUserLogin(int id) {
		userLoginRepository.deleteById(id);
		return "UserLogin got deleted successFully";
	}


	@Override
	public UserLoginDTO getUserLoginById() {
		// TODO Auto-generated method stub
		return null;
	}
}
