package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.User;
import com.example.roombooking.model.UserDTO;
@Component
public class UserConverter {

	public User convertToUserEntity(UserDTO userDto)
	{
		User user=new User();
		if(userDto!=null)
		{
			BeanUtils.copyProperties(userDto, user);
		}
		return user;
	}
	
	
	
	public UserDTO convertToUserDTO(User user) {
		UserDTO userDto=new UserDTO();
		if(user!=null)
		{
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}
}
