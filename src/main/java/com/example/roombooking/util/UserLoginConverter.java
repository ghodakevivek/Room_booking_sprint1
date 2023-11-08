package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.UserLogin;
import com.example.roombooking.model.UserLoginDTO;
@Component
public class UserLoginConverter {

	public UserLogin convertToUserLoginEntity(UserLoginDTO userLoginDto) {
		UserLogin userLogin=new UserLogin();
		if(userLoginDto!=null)
		{
			BeanUtils.copyProperties(userLoginDto, userLogin);
		}
		return userLogin;
	}

	public UserLoginDTO convertToUserLoginDTO(UserLogin uLogin) {
		UserLoginDTO userLoginDto=new UserLoginDTO();
		if(uLogin!=null)
		{
			BeanUtils.copyProperties(uLogin, userLoginDto);
		}
		return userLoginDto;
	}

	
}
